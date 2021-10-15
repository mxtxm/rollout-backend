package com.tctools.business.model.project.site;

import com.tctools.business.dto.project.*;
import com.tctools.business.dto.site.Site;
import com.vantar.business.*;
import com.vantar.database.query.QueryBuilder;
import com.vantar.exception.*;
import com.vantar.locale.VantarKey;
import com.vantar.util.collection.CollectionUtil;
import com.vantar.util.object.ObjectUtil;
import com.vantar.web.*;
import java.util.*;


public class ProjectSiteModel {

    public static ResponseMessage add(Params params) throws InputException, ServerException {
        RolloutProject project = new RolloutProject();
        project.id = params.getLong("id");
        if (ObjectUtil.isIdInvalid(project.id)) {
            throw new InputException(VantarKey.EMPTY_ID, "id (project)");
        }
        List<Long> siteIds = params.getLongList("siteids");
        List<String> siteCodes = params.getStringList("sitecodes");
        boolean siteCodeIsEmpty = CollectionUtil.isEmpty(siteCodes);
        if (CollectionUtil.isEmpty(siteIds) && siteCodeIsEmpty) {
            throw new InputException(VantarKey.EMPTY_ID, "siteids | sitecodes");
        }

        try {
            project = CommonRepoMongo.getById(project);
        } catch (NoContentException e) {
            throw new InputException(VantarKey.EMPTY_ID, "id (project)");
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.FETCH_FAIL);
        }

        if (project.sites == null) {
            project.sites = new ArrayList<>(siteIds.size());
        }

        List<Object> duplicates = new ArrayList<>();

        if (siteCodeIsEmpty) {
            for (Long siteId: siteIds) {
                Site.Viewable site = getSite(project, siteId);
                if (site != null) {
                    duplicates.add(siteId);
                    continue;
                }

                site = new Site.Viewable();
                site.id = siteId;
                try {
                    project.sites.add(CommonRepoMongo.getById(site));
                } catch (NoContentException e) {
                    throw new InputException(VantarKey.EMPTY_ID, "siteids");
                } catch (DatabaseException e) {
                    throw new ServerException(VantarKey.FETCH_FAIL);
                }
            }
        } else {
            for (String code : siteCodes) {
                Site.Viewable site = getSite(project, code);
                if (site != null) {
                    duplicates.add(code);
                    continue;
                }

                QueryBuilder q = new QueryBuilder(new Site.Viewable());
                q.condition().equal("code", code);
                try {
                    project.sites.add(CommonRepoMongo.getFirst(q));
                } catch (NoContentException e) {
                    throw new InputException(VantarKey.EMPTY_ID, "siteids");
                } catch (DatabaseException e) {
                    throw new ServerException(VantarKey.FETCH_FAIL);
                }
            }
        }

        try {
            CommonRepoMongo.update(project);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }
        return new ResponseMessage(VantarKey.UPDATE_SUCCESS, duplicates, project);
    }

    public static ResponseMessage remove(Params params) throws InputException, ServerException {
        RolloutProject project = new RolloutProject();
        project.id = params.getLong("id");
        if (ObjectUtil.isIdInvalid(project.id)) {
            throw new InputException(VantarKey.EMPTY_ID, "id (project)");
        }
        Set<Long> siteIds = params.getLongSet("siteids");
        Set<String> siteCodes = params.getStringSet("sitecodes");
        boolean siteCodeIsEmpty = CollectionUtil.isEmpty(siteCodes);
        if (CollectionUtil.isEmpty(siteIds) && siteCodeIsEmpty) {
            throw new InputException(VantarKey.EMPTY_ID, "siteids | sitecodes");
        }

        try {
            project = CommonRepoMongo.getById(project);
        } catch (NoContentException e) {
            throw new InputException(VantarKey.EMPTY_ID, "id (project)");
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.FETCH_FAIL);
        }

        if (project.sites == null) {
            project.sites = new ArrayList<>(siteIds.size());
        }

        Iterator<Site.Viewable> itr = project.sites.iterator();
        while (itr.hasNext()) {
            Site.Viewable site = itr.next();
            if (siteCodeIsEmpty) {
                if (siteIds.contains(site.id)) {
                    itr.remove();
                }
            } else if (siteCodes.contains(site.code)) {
                itr.remove();
            }
        }

        try {
            CommonRepoMongo.update(project);
        } catch (DatabaseException e) {
            throw new ServerException(VantarKey.UPDATE_FAIL);
        }
        return new ResponseMessage(VantarKey.UPDATE_SUCCESS, project);
    }

    private static Site.Viewable getSite(RolloutProject project, Long siteId) {
        for (Site.Viewable site : project.sites) {
            if (site.id.equals(siteId)) {
                return site;
            }
        }
        return null;
    }

    private static Site.Viewable getSite(RolloutProject project, String siteCode) {
        for (Site.Viewable site : project.sites) {
            if (site.code.equals(siteCode)) {
                return site;
            }
        }
        return null;
    }
}
