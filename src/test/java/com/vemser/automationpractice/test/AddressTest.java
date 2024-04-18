package com.vemser.automationpractice.test;

import com.vemser.automationpractice.dto.AddressDto;
import com.vemser.automationpractice.factory.data.AddressData;
import com.vemser.automationpractice.page.AddressPage;
import org.junit.Assert;
import org.junit.Test;

public class AddressTest extends BaseTest{

    AddressPage addressPage = new AddressPage();
    AddressData addressData = new AddressData();



    @Test
    public void verifyAddressCreationWithValidData(){

        AddressDto addressDto = addressData.insertAddressWithValidData();

        addressPage.verifyHomePage();
        addressPage.doLogin("camila@camila5.com", "12345678");
        addressPage.confirmPageMyAccount();
        addressPage.clickBtnAddMyFirstAddress();
        addressPage.confirmPageYourAddress();
        addressPage.fillCompanyField(addressDto.getCompany());
        addressPage.fillAddressField(addressDto.getAddress());
        addressPage.fillAddressSecondaryField(addressDto.getAddressLine2());
        addressPage.fillCityField(addressDto.getCity());
        addressPage.selectState(addressDto.getState());
        addressPage.fillZipPostalCodeField(addressDto.getZipPostalCode());
        addressPage.selectCountry(addressDto.getCountry());
        addressPage.fillHomePhoneField(addressDto.getHomePhone());
        addressPage.fillMobilePhoneField(addressDto.getMobilePhone());
        addressPage.fillAdditionalInformationField(addressDto.getAdditionalInformation());
        addressPage.fillNameAddressField(addressDto.getNameAddress());

        addressPage.clickBtnSave();
        addressPage.confirmPageMyAddresses();
        addressPage.clickBtnDelete();
        addressPage.alert_clickToAccept();
        String msg = addressPage.confirmDeletedAddress();
        Assert.assertEquals(msg, "No addresses are available. Add a new address" );

    }


    @Test
    public void verifyAddressCreationWithValidData2(){

        AddressDto addressDto = addressData.insertAddressWithValidData();

        addressPage.registerNewAddressPage();

        addressPage.fillCompanyField(addressDto.getCompany());
        addressPage.fillAddressField(addressDto.getAddress());
        addressPage.fillAddressSecondaryField(addressDto.getAddressLine2());
        addressPage.fillCityField(addressDto.getCity());
        addressPage.selectState(addressDto.getState());
        addressPage.fillZipPostalCodeField(addressDto.getZipPostalCode());
        addressPage.selectCountry(addressDto.getCountry());
        addressPage.fillHomePhoneField(addressDto.getHomePhone());
        addressPage.fillMobilePhoneField(addressDto.getMobilePhone());
        addressPage.fillAdditionalInformationField(addressDto.getAdditionalInformation());
        addressPage.fillNameAddressField(addressDto.getNameAddress());

        addressPage.confirmAddressCreate();
        addressPage.deleteAddress();
        String msg = addressPage.confirmDeletedAddress();
        Assert.assertEquals(msg, "No addresses are available. Add a new address" );

    }

    @Test
    public void verifyAddressCreationWithInvalidData(){

        AddressDto addressDto = addressData.insertAddressWithInvalidData();

        addressPage.registerNewAddressPage();

        addressPage.fillCompanyField(addressDto.getCompany());
        addressPage.fillAddressField(addressDto.getAddress());
        addressPage.fillAddressSecondaryField(addressDto.getAddressLine2());
        addressPage.fillCityField(addressDto.getCity());
        addressPage.selectState(addressDto.getState());
        addressPage.fillZipPostalCodeField(addressDto.getZipPostalCode());
        addressPage.selectCountry(addressDto.getCountry());
        addressPage.fillHomePhoneField(addressDto.getHomePhone());
        addressPage.fillMobilePhoneField(addressDto.getMobilePhone());
        addressPage.fillAdditionalInformationField(addressDto.getAdditionalInformation());
        addressPage.fillNameAddressField(addressDto.getNameAddress());

        addressPage.clickBtnSave();

        String msg = addressPage.errorMessageCreatedAddress();
        Assert.assertEquals(msg, "You must register at least one phone number." );

    }



}
