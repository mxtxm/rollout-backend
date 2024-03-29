package com.tctools.business.admin.model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.tctools.business.dto.location.*;
import com.tctools.business.dto.site.*;
import com.tctools.business.dto.system.Settings;
import com.tctools.business.service.locale.AppLangKey;
import com.tctools.common.util.Excel;
import com.vantar.admin.model.Admin;
import com.vantar.business.CommonRepoMongo;
import com.vantar.database.common.ValidationError;
import com.vantar.database.datatype.Location;
import com.vantar.database.dto.*;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.Locale;
import com.vantar.locale.*;
import com.vantar.service.Services;
import com.vantar.service.cache.ServiceDtoCache;
import com.vantar.util.datetime.DateTime;
import com.vantar.util.file.FileUtil;
import com.vantar.util.object.ObjectUtil;
import com.vantar.util.string.*;
import com.vantar.web.*;
import org.slf4j.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class AdminSiteImport {

    private static final Logger log = LoggerFactory.getLogger(AdminSiteImport.class);
    private static Map<String, String> stringMaps;
    private static Map<String, Long> codeIdMap;


    public static void importSites(Params params, HttpServletResponse response) {
        WebUi ui = Admin.getUi(Locale.getString(AppLangKey.IMPORT_SITE_DATA), params, response);
        if (ui == null) {
            return;
        }

        if (!params.contains("f")) {
            String fields =
                "Region\n" + //0
                "Province\n" + //1
                "City\n" + //2
                "code\n" + //3
                "comment\n" + //4
                "...\n" + //5
                "...\n" + //6
                "...\n" + //7
                "District\n" + //8
                "LocationType\n" + //9
                "name:fa\n" + //10
                "name:en\n" + //11
                "address\n" + //12
                "latitude\n" + //13
                "longitude\n" + //14
                "SiteOwnership\n" + //15
                "controller\n" + //16
                "BtsStatus\n" + //17
                "setupDate\n" + //18
                "BtsOwnership\n" + //19
                "contractStartDate\n" + //20
                "...\n" + //21
                "etcTransceiverCount\n" + //22
                "SiteType\n" + //23
                "SiteClass\n" + //24
                "BtsInstall\n" + //25
                "BtsTowerType\n" + //26
                "towerHeight\n" + //27
                "buildingHeight\n" + //28
                "frequencyBand\n" + //29
                "Sector A:height\n" + //30
                "Sector A:antennaCount\n" + //31
                "Sector A:azimuth\n" + //32
                "Sector A:mechanicalTilt\n" + //33
                "Sector A:LocationType\n" + //34
                "Sector A2:height\n" + //35
                "Sector A2:azimuth\n" + //36
                "Sector A2:mechanicalTilt\n" + //37
                "Sector B:height\n" + //38
                "Sector B:antennaCount\n" + //39
                "Sector B:azimuth\n" + //40
                "Sector B:mechanicalTilt\n" + //41
                "Sector B:LocationType\n" + //42
                "Sector B2:height\n" + //43
                "Sector B2:azimuth\n" + //44
                "Sector B2:mechanicalTilt\n" + //45
                "Sector C:height\n" + //46
                "Sector C:antennaCount\n" + //47
                "Sector C:azimuth\n" + //48
                "Sector C:mechanicalTilt\n" + //49
                "Sector C:LocationType\n" + //50
                "Sector C2:height\n" + //51
                "Sector C2:azimuth\n" + //52
                "Sector C2:mechanicalTilt\n" + //53
                "Sector D:height\n" + //54
                "Sector D:antennaCount\n" + //55
                "Sector D:azimuth\n" + //56
                "Sector D:mechanicalTilt\n" + //57
                "Sector D:SectorOptimization\n" + //58
                "Sector D2:height\n" + //59
                "Sector D2:azimuth\n" + //60
                "Sector D2:mechanicalTilt\n" + //61
                "assignable\n" + //62
                "Sector A:electricalTilt\n" + //63
                "Sector B:electricalTilt\n" + //64
                "Sector C:electricalTilt"; //65

            ui.beginUploadForm()
                .addEmptyLine()
                .addFile(Locale.getString(AppLangKey.IMPORT_BTS_FILE), "csv")
                .addInput("Codes", "codes")
                .addTextArea(Locale.getString(AppLangKey.IMPORT_BTS_FIELD_ORDER), "fields", fields)
                .addCheckbox("Synch all Radio Metric states", "synchallradiometric")
                .addCheckbox("Synch all HSE Audit states", "synchallhse")
                .addSubmit(Locale.getString(VantarKey.ADMIN_IMPORT))
                .finish();
            return;
        }

        // > > > I M P O R T

        long t1 = System.currentTimeMillis();
        int recordCount = 0;
        boolean doAllStatesRadioMetric = params.isChecked("synchallradiometric");
        boolean doAllStatesHseAudit = params.isChecked("synchallhse");

        ui.addMessage("db > sites").write();
        loadSites(ui);

        String[] fields = StringUtil.split(params.getString("fields"), '\n');
        Set<String> codes = params.getString("codes") == null ? null : StringUtil.splitToSet(params.getString("codes"), ',');
        String path = FileUtil.getTempDirectory() + new DateTime().getAsTimestamp();

        ui.addMessage("db > operators").write();
        Map<String, Long> operatorIds = new HashMap<>();
        Set<String> operatorNames = new HashSet<>();
//        for (Operator operator : Services.get(ServiceDtoCache.class).getList(Operator.class)) {
//            String name = normalizeMore(operator.name.get("fa"));
//            operatorIds.put(name, operator.id);
//            operatorNames.add(name);
//            operatorNames.add(operator.name.get("en"));
//        }

        try {
            // > > > UPLOAD
            Params.Uploaded uploaded = params.upload("csv");
            uploaded.moveTo(path);

            // > > > CONVERT TO CSV IF NEEDED
            if (StringUtil.contains(uploaded.getOriginalFilename(), ".xlsx")) {
                ui.addMessage("xlsx > csv").write();
                Excel.excelToCSV(path, path + ".csv", 0, fields.length);
                FileUtil.removeFile(path);
                path += ".csv";
            }

            // > > > READ CSV
            ui.addMessage("processing csv data...").write();
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] record;
            int i = 0;

            // > > > RECORD
            while ((record = reader.readNext()) != null) {
                if (++i == 1) {
                    continue;
                }

                String cityEn = record[6];
                if (StringUtil.isEmpty(record[2])) {
                    record[2] = record[5];
                }

                Site site = new Site();
                Long provinceId = null;
                site.location = new Location();
//                Map<String, Sector> sectors = new HashMap<>(8);
//                sectors.put("A", new Sector("A"));
//                sectors.put("A2", new Sector("A2"));
//                sectors.put("B", new Sector("B"));
//                sectors.put("B2", new Sector("B2"));
//                sectors.put("C", new Sector("C"));
//                sectors.put("C2", new Sector("C2"));
//                sectors.put("D", new Sector("D"));
//                sectors.put("D2", new Sector("D2"));

                boolean exclude = false;

                // > > > 21 share
//                String shared = record[21];
//                if (shared == null || shared.contains("مشترک نمی باشد")) {
//                    site.collocationType = CollocationType.None;
//                } else {
//                    CollocationType collocationTypeOther;
//                    if (shared.contains("میزبان")) {
//                        collocationTypeOther = CollocationType.Host;
//                        site.collocationType = CollocationType.Guest;
//                    } else if (shared.contains("مهمان")) {
//                        collocationTypeOther = CollocationType.Guest;
//                        site.collocationType = CollocationType.Host;
//                    } else {
//                        collocationTypeOther = null;
//                        site.collocationType = CollocationType.None;
//                    }
//
//                    if (collocationTypeOther != null) {
//                        site.collocations = new ArrayList<>();
//                        String text = normalizeMore(shared);
//                        for (String operatorName : operatorNames) {
//                            if (text.contains(operatorName)) {
//                                Collocation c = new Collocation();
//                                c.type = collocationTypeOther;
//                                c.operatorId = operatorIds.get(operatorName);
//                                site.collocations.add(c);
//                            }
//                        }
//                    }
//                }

                // > > > FIELD
                for (int k = 0; k < fields.length; ++k) {
                    if ("...".equals(fields[k])) {
                        continue;
                    }
                    if (codes != null && site.code != null && !codes.contains(site.code)) {
                        exclude = true;
                        break;
                    }

                    String value = getString(record[k]);
                    String[] field = StringUtil.split(fields[k], ':');
                    String fieldName = field[0];
                    String fieldInfo = field.length == 2 ? field[1] : null;

                    // > > > SECTOR
//                    if (fieldName.startsWith("Sector")) {
//                        Sector sector = sectors.get(fieldName.substring(Math.max(fieldName.length() - 2, 0)).trim());
//                        fieldName = fieldInfo;
//
//                        if (StringUtil.isEmpty(value)) {
//                            ObjectUtil.setPropertyValue(sector, fieldName, null);
//                            continue;
//                        }
//
//                        if (fieldName.equals("LocationType")) {
//                            Dto dto = ObjectUtil.getInstance("com.tctools.business.dto.location." + fieldName);
//                            ObjectUtil.setPropertyValue(sector, getPropertyNameFromReference(dto), getId(ui, dto, value, null));
//                            continue;
//                        }
//                        if (fieldName.equals("SectorOptimization")) {
//                            Dto dto = ObjectUtil.getInstance("com.tctools.business.dto.site." + fieldName);
//                            ObjectUtil.setPropertyValue(sector, getPropertyNameFromReference(dto), getId(ui, dto, value, null));
//                            continue;
//                        }
//
//                        if (value.equalsIgnoreCase("omni")) {
//                            sector.isOmni = true;
//                        }
//                        if (value.equalsIgnoreCase("directional")) {
//                            sector.isDirectional = true;
//                        }
//
//                        ObjectUtil.setPropertyValue(sector, fieldName, value);
//                        if (sector.height != null) {
//                            sector.onSiteHeight = sector.height;
//                        }
//                        continue;
//                    }
                    // < < < SECTOR
//1396-12-14
                    //  > > > LOCATION
                    if (value != null && fieldName.equals("longitude")) {
                        site.location.longitude = StringUtil.toDouble(value);
                        continue;
                    }
                    if (value != null && fieldName.equals("latitude")) {
                        site.location.latitude = StringUtil.toDouble(value);
                        continue;
                    }
                    // < < < LOCATION

                    if (value != null && (fieldName.equals("btsShare") || fieldName.equals("BtsTowerType"))
                        && normalize(value).contains("نشده")) {

                        value = null;
                    }
                    if (StringUtil.isEmpty(value)) {
                        site.setPropertyValue(fieldName, null);
                        continue;
                    }

                    for (String p : new String[] {"com.tctools.business.dto.location", "com.tctools.business.dto.site"}) {
                        Dto dto = ObjectUtil.getInstance(p + "." + fieldName);

                        // > > > SCALAR VALUE
                        if (dto == null) {
                            if (fieldInfo == null) {
                                if ((fieldName.equals("towerHeight") || fieldName.equals("buildingHeight"))
                                    && !StringUtil.isNumeric(value)) {

                                    site.setPropertyValue(fieldName, null);
                                    continue;
                                }

                                if (fieldName.equals("setupDate") || fieldName.equals("contractStartDate")) {
                                    DateTime dt;
                                    try {
                                        if (value.equals("قبل از سال 93")) {
                                            value = "1391-01-01";
                                        }
                                        dt = new DateTime(value);
                                    } catch (DateTimeException e) {
                                        ui.addErrorMessage(
                                            "WARNING " + site.code + " > invalid date " + fieldName + " >" + value + "<"
                                        ).write();
                                        dt = null;
                                    }
                                    site.setPropertyValue(fieldName, dt);
                                    continue;
                                }

                                site.setPropertyValue(fieldName, value);
                                continue;
                            }
                            // > > > lang
                            Map<String, String> propertyValue = (Map<String, String>) site.getPropertyValue(fieldName);
                            if (propertyValue == null) {
                                propertyValue = new HashMap<>(2);
                                site.setPropertyValue(fieldName, propertyValue);
                            }
                            propertyValue.put(fieldInfo, value);
                            continue;
                        }
                        // < < < SCALAR VALUE

                        // > > > REFERENCE VALUE
                        Long id;

                        if (dto.getClass().equals(City.class)) {
                            id = getId(ui, dto, value, cityEn, provinceId == null ? null : provinceId.toString());
                        } else {
                            id = getId(ui, dto, value);
                        }
                        if (dto.getClass().equals(Province.class)) {
                            provinceId = id;
                        }

                        site.setPropertyValue(getPropertyNameFromReference(dto), id);
                        // < < < REFERENCE VALUE
                    }
                }
                if (exclude) {
                    continue;
                }
                // < < < FIELD

                if (site.location.isEmpty()) {
                    site.location = null;
                }

//                site.sectors = new ArrayList<>(8);
//                site.sectors.addAll(sectors.values());

                List<ValidationError> validationErrors = site.validate(Dto.Action.INSERT);
                if (validationErrors != null && !validationErrors.isEmpty()) {
                    log.error("! validation error site not added {} > {}", site.code, validationErrors);
                    ui.addErrorMessage("ERROR " + site.code + " > " + ValidationError.toString(validationErrors)).write();
                    continue;
                }

                try {
                    Long id = codeIdMap.get(site.code);
                    if (id != null) {
                        QueryBuilder q = new QueryBuilder(site);
                        q.condition().equal("id", id);
                        CommonRepoMongo.update(site, q);
                        ui.addMessage(
                            (i-1) + " " + Locale.getString(AppLangKey.UPDATED, site.getClass().getSimpleName(), site.code)
                        ).write();
                        site = CommonRepoMongo.getFirst(q);
                    } else {
                        site.id = CommonRepoMongo.insert(site);
                        ui.addMessage(
                            (i-1) + " " + Locale.getString(AppLangKey.ADDED, site.getClass().getSimpleName(), site.code)
                        ).write();
                    }

                    // > > > hook to projects

                    // < < < hook to projects

                    ++recordCount;
                } catch (DatabaseException | NoContentException e) {
                    log.error("! unexpected error ({})", site, e);
                    ui.addErrorMessage(e).write();
                }
            }
            // < < < RECORD

        } catch (IOException | CsvValidationException e) {
            ui.addErrorMessage(e).write();
        }

        try {
            QueryBuilder q = new QueryBuilder(new Settings());
            q.condition().equal("key", Settings.KEY_ARAS_UPDATE);
            CommonRepoMongo.delete(q);
            Settings settings = new Settings();
            settings.key = Settings.KEY_ARAS_UPDATE;
            settings.value = new DateTime().formatter().getDate();
            CommonRepoMongo.insert(settings);
        } catch (Exception e) {
            ui.addErrorMessage(e);
        }

        ui.addMessage("Finished! " + recordCount + " took " + ((System.currentTimeMillis() - t1) / 1000 / 60 / 60) + " minutes").finish();
    }

    private static String getString(String value) {
        value = StringUtil.remove(value, '–');
        if (stringMaps == null) {
            stringMaps = new HashMap<>();
            stringMaps.put("BTS نصب نشده است", "نصب نشده");
            stringMaps.put("دکل نصب نشده است", "نصب نشده");
            stringMaps.put("NOK", null);
            stringMaps.put("NotExist", null);
            stringMaps.put("Not Exist", null);
            stringMaps.put("0000-00-00", null);
            stringMaps.put("توافقی", null);
            stringMaps.put("ندارد", null);
            stringMaps.put("not", null);
            stringMaps.put("مشترک نمی باشد", null);
            stringMaps.put("تهران - نامشخص", null);
            stringMaps.put("فاقد", null);
            stringMaps.put("نامشخص", null);
            stringMaps.put("no tower", null);
            stringMaps.put("not e", null);
            stringMaps.put("نامحدود", null);
        }

        for (Map.Entry<String, String> entry : stringMaps.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(value)) {
                return entry.getValue();
            }
        }
        return value;
    }

    private static void loadSites(WebUi ui) {
        codeIdMap = new HashMap<>();
        try {
            for (Dto dto : CommonRepoMongo.getAll(new Site.ViewableIdCode())) {
                codeIdMap.put(((Site.ViewableIdCode) dto).code, ((Site.ViewableIdCode) dto).id);
            }
        } catch (NoContentException e) {
            ui.addMessage("no sites in database");
        } catch (DatabaseException e) {
            log.error("! error loading sites", e);
            ui.addErrorMessage("can not load sites");
        }
    }

    private static <T extends Dto> Long getId(WebUi ui, T obj, String... values) {
        for (String name : values) {
            String nValue = normalize(name);

//            if (StringUtil.isEmpty(nValue)) {
//                continue;
//            }

            List<T> dtos = (List<T>) Services.get(ServiceDtoCache.class).getList(obj.getClass());
            for (T dto : dtos) {
                if (dto.hasAnnotation("name", Localized.class)) {
                    for (String v : ((Map<String, String>) dto.getPropertyValue("name")).values()) {
                        if (equals(nValue, normalize(v))) {
                            return dto.getId();
                        }
                    }
                } else {
                    if (equals(nValue, normalize(dto.getPropertyValue("name").toString()))) {
                        return dto.getId();
                    }
                }
            }
        }

        try {
            if (obj.hasAnnotation("name", Localized.class)) {
                Map<String, String> map = (Map<String, String>) obj.getPropertyValue("name");
                if (map == null) {
                    map = new HashMap<>(2);
                }
                map.put(Persian.containsPersian(values[0]) ? "fa" : "en", values[values.length > 1 ? 1 : 0]);
                obj.setPropertyValue("name", map);
            } else {
                obj.setPropertyValue("name", values[0]);
            }

            if (obj instanceof City) {
                ((City) obj).provinceId = StringUtil.toLong(values[3]);
            }

            long id = CommonRepoMongo.insert(obj);
            ui.addMessage(
                Locale.getString(AppLangKey.ADDED, obj.getClass().getSimpleName(), "(" + id + ") " + values[0])
            ).write();
            log.warn("! inserted new({}) > {}", obj.getClass().getSimpleName(), values[0]);
            return id;
        } catch (Exception e) {
            log.error("! failed insert ({}, {})", obj.getClass().getSimpleName(), values[0], e);
            ui.addErrorMessage(e).write();
            return null;
        }
    }

    private static String getPropertyNameFromReference(Dto dto) {
        char[] c = dto.getClass().getSimpleName().toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c) + "Id";
    }

    private static String normalize(String string) {
        return string == null ? "" : StringUtil.remove(string, '-', ',', '،', '_', '"', '\'', ' ');
    }

    private static String normalizeMore(String string) {
        return string == null ?
            "" : StringUtil.replace(StringUtil.remove(string, '-', ',', '،', '_', '"', '\'', ' '), 'آ', 'ا');
    }

    private static boolean equals(String v1, String v2) {
        if (v1 == null || v2 == null) {
            return false;
        }
        v1 = StringUtil.replace(v1, 'آ', 'ا');
        v2 = StringUtil.replace(v2, 'آ', 'ا');
        if (v1.equalsIgnoreCase(v2)) {
            return true;
        }
        List<Character> v1Set = v1.chars().mapToObj(e->(char) e).collect(Collectors.toList());
        List<Character> v2Set = v2.chars().mapToObj(e->(char) e).collect(Collectors.toList());

        Character prevChar = null;
        Iterator<Character> itr = v1Set.iterator();
        while (itr.hasNext()) {
            char c = itr.next();
            if (prevChar != null && prevChar == c) {
                itr.remove();
                continue;
            }
            prevChar = c;
        }
        itr = v2Set.iterator();
        while (itr.hasNext()) {
            char c = itr.next();
            if (prevChar != null && prevChar == c) {
                itr.remove();
                continue;
            }
            prevChar = c;
        }
        return v1Set.equals(v2Set);
    }
}