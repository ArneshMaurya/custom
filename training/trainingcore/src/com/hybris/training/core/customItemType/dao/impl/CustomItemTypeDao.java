package com.hybris.training.core.customItemType.dao.impl;

import com.hybris.training.core.model.CustomItemtypeModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

public class CustomItemTypeDao extends AbstractItemDao {
    private static final String CUSTOM_QUERY = "select {c.pk} from {CustomItemtype as c}";

    public List<CustomItemtypeModel> getAllRecds(){
        final FlexibleSearchQuery query = new FlexibleSearchQuery(CUSTOM_QUERY);
        SearchResult<CustomItemtypeModel> result = getFlexibleSearchService().search(query);
        return result.getResult();
    }
}
