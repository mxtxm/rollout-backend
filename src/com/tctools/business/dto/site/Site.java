package com.tctools.business.dto.site;

import com.tctools.business.dto.location.*;
import com.vantar.database.datatype.Location;
import com.vantar.database.dto.*;
import java.util.*;

@Mongo
@DeleteLogical
@Index({"code:1", "location:2dsphere",})
public class Site extends DtoBase {

    public Long id;
    @Required
    public String code;
    @Localized
    public Map<String, String> name;

    public Long siteClassId;
    public Long siteTypeId;

    // location > > >
    public Long regionId;
    @Required
    public Long provinceId;
    @Required
    public Long cityId;
    public Long districtId;
    public Long locationTypeId;
    public String address;
    @Required
    public Location location;

    public String candidate;

    public List<String> frequency;  // 2G900, 2G1800, 3G2100, 4G1800
    public List<String> technology; // for search 2G 3G 4G

    public String description;


    @Override
    public boolean beforeInsert() {
        return beforeUpdate();
    }

    @Override
    public boolean beforeUpdate() {
        code = code.toUpperCase();
        return true;
    }



    @Storage("Site")
    public static class Viewable extends DtoBase {

        public Long id;
        public String code;

        @DeLocalized
        public String name;

        @FetchCache(dto = com.tctools.business.dto.site.SiteClass.class, field = "siteClassId")
        public SiteClass.Localed siteClass;
        @FetchCache(dto = com.tctools.business.dto.site.SiteType.class, field = "siteTypeId")
        public SiteType.Localed siteType;

        public String frequencyBand;

        // location > > >
        @FetchCache(dto = com.tctools.business.dto.location.Region.class, field = "regionId")
        public Region.Localed region;
        @FetchCache(dto = com.tctools.business.dto.location.Province.class, field = "provinceId")
        public Province.Localed province;
        @FetchCache(dto = com.tctools.business.dto.location.City.class, field = "cityId")
        public City.Localed city;
        @FetchCache("districtId")
        public District district;
        @FetchCache(dto = com.tctools.business.dto.location.LocationType.class, field = "locationTypeId")
        public LocationType.Localed locationType;
        public String address;
        public Location location;
        // < < < location


        @Override
        public void afterFetchData() {

        }
    }



    @Storage("Site")
    public static class ViewableTiny extends DtoBase {

        public Long id;
        public String code;

        @DeLocalized
        public String name;

        @FetchCache(dto = com.tctools.business.dto.location.Province.class, field = "provinceId")
        public Province.Localed province;
        @FetchCache(dto = com.tctools.business.dto.location.City.class, field = "cityId")
        public City.Localed city;
        public String address;
        public Location location;
    }



    @Storage("Site")
    public static class ViewableIdCode extends DtoBase {

        public Long id;
        public String code;
    }
}