package com.hybris.training.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;

import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
@RequestMapping( value = "/test")
public class MyTestLandingController  extends AbstractPageController{

    private static final String TEST_CMS_PAGE_CON = "testCMSPage";
    @Autowired
    private UserFacade userFacade;
    @Autowired
    private CustomerFacade customerFacade;
    @Autowired
    private UserService userService;
    @Autowired
    private ConfigurationService configurationService;
    @RequestMapping(method = RequestMethod.GET)
    public String getTest(final Model model) throws CMSItemNotFoundException
    {
        ContentPageModel testCMSPage = getContentPageForLabelOrId(TEST_CMS_PAGE_CON);
        String uid = configurationService.getConfiguration().getString("custom.UID","customer.support.1@sap.com");
        UserModel userModel = userService.getUserForUID(uid);
        model.addAttribute("name",userModel.getName());
        model.addAttribute("uid",userModel.getUid());
        model.addAttribute("TenantId",userModel.getTenantId());
        model.addAttribute("Addresses",userModel.getAddresses());
        storeCmsPageInModel(model,testCMSPage);
        setUpMetaDataForContentPage(model,testCMSPage);
        return getViewForPage(model);
    }

}

