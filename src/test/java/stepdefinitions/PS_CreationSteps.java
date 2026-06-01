/*
 * Creation : 2 Apr 2025
 */
package stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.ContribApplicationMaintenancePage;
import com.sogeti.automation.test.pageFactory.PS_CreationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PS_CreationSteps extends TestClass {

    TestContext testContext;
    PS_CreationPage pS_CreationPage;
    ContribApplicationMaintenancePage contribApplicationMaintenancePage;

    public PS_CreationSteps(TestContext context) throws Exception {
        this.testContext = context;
        pS_CreationPage = testContext.getPageObjectManager().getpS_CreationPage();
        contribApplicationMaintenancePage = testContext.getPageObjectManager().getcontribApplicationMaintenancePage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("The user should on login page")
    public void The_user_should_on_login_page() throws FileNotFoundException, ClassNotFoundException, IOException {
        pS_CreationPage.LoginPage();

    }

    @When("user click on peugeot")
    public void user_click_on_peugeot() throws Exception {
        pS_CreationPage.verifyHomePageBrand();

    }

    @When("^User enter valid userID(.*)")
    public void User_enter_valid_userID(String UserName) {
        pS_CreationPage.LoginWithUsername(UserName);
    }

    @Then("User able to select account")
    public void user_able_to_select_account() throws Exception {
        pS_CreationPage.SelectAccount();
    }

    @Then("^User able to enter userID(.*) and Password(.*)")
    public void user_able_to_enter_user_id_and_password(String UserID, String Password) throws Exception {
        pS_CreationPage.LoginWithMFAProcess(UserID, Password);
    }

    @And("User click on signin button")
    public void user_click_on_signin_button() {
        pS_CreationPage.SignIn();
    }

    @And("User click yes button")
    public void user_click_yes_button() {
        pS_CreationPage.UserAcceptance();
    }

    @When("user click on next button")
    public void user_click_on_next_button() throws IOException {
        pS_CreationPage.Next();
    }

    @Given("user navigate to contrib admin tab")
    public void user_navigate_to_contrib_admin_tab() throws Exception {
        pS_CreationPage.ContribAdmin();
    }

    @When("user click on Configuration User sub tab")
    public void user_click_on_Configuration_User_sub_tab() throws Exception {
        pS_CreationPage.ContribA();
    }

    @Then("user able to select the language in dropdown")
    public void user_select_the_language(List<List<String>> SelectedLang) throws Exception {
        pS_CreationPage.DropdownMethods(SelectedLang);
    }

    @Then("user click on validate btn")
    public void user_click_on_validate() throws Exception {

        pS_CreationPage.Validation();
    }

    @When("user is on the home page")
    public void user_is_on_the_home_page() {

        // List<Map<String, String>> dataTable
        // String url = dataTable.get(0).get("url");

        // pS_CreationPage.SecondUrl(url);

        pS_CreationPage.GetUrl();
    }

    @And("user check the vehicle is presant or not")
    public void user_check_the_vehicle_is_presant_or_not() {
        pS_CreationPage.VehiclePrasent();
    }

    @And("user able to see the text message")
    public void user_able_to_see_the_text_message() {
        pS_CreationPage.TextPrasent();
    }

    @When("user should able to see the pa study")
    public void user_should_able_to_see_the_pa_study() throws Exception {

        pS_CreationPage.MouseOverPf();

    }

    @Then("user click on creation")
    public void user_click_on_creation() throws Exception {

        pS_CreationPage.CreationMethod();

    }

    @Then("user able to see the Head of profitabilty study page")
    public void user_able_to_see_the_head_of_profitabilty_study_page() {
        String actualTitle = pS_CreationPage.getPageTitle();
        String expectedTitle = "osc002_01";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

        System.out.println("Current page Title: " + actualTitle);

        // Assert.assertEquals(pS_CreationPage.getPageTitle(), "osc002_01", "Page title does not match the expected value.");

    }

    @When("user click on Create Amendment")
    public void user_click_on_create_amendment() throws Exception {
        pS_CreationPage.ClientCreation();
    }

    @Then("user able to see the create a client page")
    public void user_able_to_see_the_create_a_client_page() {
        String actualTitle = pS_CreationPage.getPageTitle();
        String expectedTitle = "osc002_11";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

        System.out.println("Current page Title: " + actualTitle);

    }

    @Then("^user fill the client full name filed(.*)")
    public void user_fill_the_client_full_name_filed(String ClientName) throws Exception {
        pS_CreationPage.NameOfClient(ClientName);

    }

    @Then("user click on cancel btn")
    public void user_click_on_cancel_btn() {
        pS_CreationPage.CancelClientCreation();
    }

    @When("user click on Create Btn")
    public void user_click_on_create_btn() throws Exception {
        pS_CreationPage.SaveClient();
    }

    @Then("User able to see the new created client on PS study creation Page")
    public void user_able_to_see_the_new_created_client_on_ps_study_creation_page() throws Exception {
        pS_CreationPage.getFilteredClientName();
    }

    @When("user click on delete btn")
    public void user_click_on_delete_btn() {
        pS_CreationPage.DeleteClient();

    }

    @Then("user click on versiondelete btn")
    public void user_click_on_versiondelete_btn() {
        pS_CreationPage.Delete();
    }

    @Then("user click on delete option")
    public void user_click_on_delete_option() throws Exception {
        pS_CreationPage.DeleteBtn();
    }

    @When("user click ok for delete confirmation")
    public void user_click_ok_for_delete_confirmation() {
        pS_CreationPage.AcceptDelete();
    }

    /*
     * @Then("user able to see client deleted massage in Head of profitabilty study page") public void
     * user_able_to_see_client_deleted_massage_in_head_of_profitabilty_study_page() { pS_CreationPage.fatchDeleteTitle(); }
     */

    @Given("user is on cc page")
    public void user_is_on_cc_page() throws Exception {
        pS_CreationPage.GetUrlCC();
    }

    @When("user click on country")
    public void user_click_on_country(List<List<String>> countrys) throws Exception {
        pS_CreationPage.SelectCountry(countrys);

    }

//    @And("user click on client")
//    public void user_click_on_client(List<List<String>> clients) throws Exception {
//        pS_CreationPage.SelectClient(clients);
//
//    }

    @And("user click on client")
    public void user_click_on_client() throws Exception {
        pS_CreationPage.SelectClient();

    }

    @And("^user enter the status code(.*)")
    public void user_enter_the_status_code(String scode) {

        pS_CreationPage.SelectStatus(scode);

    }

    @Then("user select the starting date")
    public void user_select_the_starting_date(List<List<String>> startdate) throws Exception {

        pS_CreationPage.SelectDate(startdate);

    }

    @Then("user select the ending date")
    public void user_select_the_ending_date(List<List<String>> enddate) throws Exception {

        pS_CreationPage.SelectEndDate(enddate);

    }

    @Then("^user select the valid start date(.*)")
    public void user_select_the_valid_start_date(String ValidStartdate) {
        pS_CreationPage.VerifyStartDate(ValidStartdate);

    }

    @And("^user select the valid end date(.*)")
    public void user_select_the_valid_end_date(String ValidEnddate) {
        pS_CreationPage.VerifyEndDate(ValidEnddate);
    }

    @Then("user click on validate button")
    public void user_click_on_validate_button() throws Exception {

        pS_CreationPage.Validationbtn();

    }

//    @When("user click on model range")
//    public void user_click_on_model_range(List<List<String>> rangedetails) throws Exception {
//
//        pS_CreationPage.FamilyModelRange(rangedetails);
//    }
    @When("user click on model range")
    public void user_click_on_model_range() throws Exception {

        pS_CreationPage.FamilyModelRange();
    }

//    @And("user select the valid version date")
//    public void user_select_the_valid_version_date(List<List<String>> valuedetails) throws Exception {
//
//        pS_CreationPage.ValidateDate(valuedetails);
//    }

    @And("user select the valid version date")
    public void user_select_the_valid_version_date() throws Exception {

        pS_CreationPage.ValidateDate();
    }

    @And("user click on searching")
    public void user_click_on_searching() throws Exception {

        pS_CreationPage.SearchValidationBtn();
    }

    @Then("user able to see the version lists")
    public void user_able_to_see_the_version_lists() {

        // Assert.assertTrue("Table is not displayed!", pS_CreationPage.TablePrasent());
        Assert.assertTrue(pS_CreationPage.TablePrasent(), "Table is not displayed!");
    }

//    @When("user select the version checkbox from version list")
//    public void user_select_the_version_checkbox_from_version_list(List<List<String>> checklist) throws Exception {
//
//        //user select the options for modification pS_CreationPage.CheckBox();
//        pS_CreationPage.VersionCheckBoxes(checklist);
//
//    }
    @When("user select the version checkbox from version list")
    public void user_select_the_version_checkbox_from_version_list() throws Exception {

        // pS_CreationPage.CheckBox();
        pS_CreationPage.VersionCheckBoxes();

    }

    @Then("user able to click on add the versions in basket")
    public void user_able_to_click_on_add_the_versions_in_basket() throws Exception {

        pS_CreationPage.AddSearchBasket();
    }

    @And("user click on options")
    public void user_click_on_options() {
        pS_CreationPage.OptionsValidate();
    }

//    @Then("user select the option check boxes")
//    public void user_select_the_option_check_boxes(List<List<String>> checkoptionlist) throws Exception {
//        pS_CreationPage.CheckBoxOptions(checkoptionlist);
//
//    }
    @Then("user select the option check boxes")
    public void user_select_the_option_check_boxes() throws Exception {
        pS_CreationPage.CheckBoxOptions();

    }

    @And("user can validate")
    public void user_can_validate() {
        pS_CreationPage.ValidatedOptions();
    }

//    @Then("user select the versions in list")
//    public void user_select_the_versions_in_list(List<List<String>> vlist) throws Exception {
//        pS_CreationPage.FoundVersionList(vlist);
//
//    }
    @Then("user select the versions in list")
    public void user_select_the_versions_in_list() throws Exception {
        pS_CreationPage.FoundVersionList();

    }

    @Then("user click on add this versions into profitability")
    public void user_click_on_add_this_versions_into_profitability() {
        pS_CreationPage.AddVersionsPS();

    }

    @Then("user select the Invoicing")
    public void user_select_the_invoicing() throws Exception {
        pS_CreationPage.SelectBrands();
    }

    @Then("user select the B2B under channel")
    public void user_select_the_b2b_under_channel() throws Exception {
        pS_CreationPage.B2BChannel();
    }

    @Then("^user send volume number(.*)")
    public void user_send_volume_number(String volume) throws Exception {
        pS_CreationPage.SendVolumenum(volume);
    }

    @And("user click on International customer volume bonus")
    public void user_click_on_international_customer_volume_bonus() throws Exception {
        pS_CreationPage.InternationalBonus();
    }

    @And("user click on national customer volume bonus")
    public void user_click_on_national_customer_volume_bonus() {
        pS_CreationPage.NationalBonus();
    }

    @Then("user click on National customer range bonus")
    public void user_click_on_national_customer_range_bonus() throws Exception {
        pS_CreationPage.RangeBonus();
    }

    @Then("user click on Noleaser")
    public void user_click_on_noleaser() {
        pS_CreationPage.NoLasear();

    }

    @And("user click on save draft")
    public void user_click_on_save_draft() {
        pS_CreationPage.SelectDraft();
    }

    @Then("user click on save this profitability study")
    public void user_click_on_save_this_profitability_study() throws Exception {
        pS_CreationPage.SavePF();
    }

    @Then("user able to see the profitability study number")
    public void user_able_to_see_the_profitability_study_number() {
        pS_CreationPage.PFNumber();
    }

    @When("user select the export option")
    public void user_select_the_export_option(List<List<String>> exportbtn) throws Exception {
        pS_CreationPage.SelectExportBtn(exportbtn);
    }

    @Then("user click on export btn")
    public void user_click_on_export_btn() throws Exception {
        pS_CreationPage.ClickExportBtn();
    }

    @When("user click on Modify PF study")
    public void user_click_on_modify_pf_study() {
        pS_CreationPage.ModificationBtn();
    }

    @Then("user click on add version")
    public void user_click_on_add_version() {
        pS_CreationPage.AddVersionBtn();
    }

//    @Then("user select the modelrange of modification")
//    public void user_select_the_modelrange_of_modification(List<List<String>> rangedetails) throws Exception {
//        pS_CreationPage.FamilyModelRange(rangedetails);
//        // pS_CreationPage.RangeModification();
//    }
    @Then("user select the modelrange of modification")
    public void user_select_the_modelrange_of_modification() throws Exception {
        pS_CreationPage.FamilyModelRange();
        // pS_CreationPage.RangeModification();
    }

    @And("user click on modifiaction versions")
    public void user_click_on_modifiaction_versions() throws Exception {
        pS_CreationPage.ModificationVersion();
    }

    @Then("user select the found version")
    public void user_select_the_found_version() throws Exception {
        pS_CreationPage.VersionCheckBoxes();
        // pS_CreationPage.SelectCheckBoxes();
    }

    @Then("user select the options for modification")
    public void user_select_the_options_for_modification() throws Exception {
        pS_CreationPage.CheckBoxOptions();
        // pS_CreationPage.ModificationCheckBoxOptions();
    }

    @Then("user click the optionvalidate button")
    public void user_click_the_optionvalidate_button() throws Exception {
        pS_CreationPage.ModificationValidatedOptions();
    }

    @When("user click on choice of the car families btn")
    public void user_click_on_choice_of_the_car_families_btn() {
        pS_CreationPage.ChoiceOfCarFamily();
    }

    @Then("user able to see car family page")
    public void user_able_to_see_car_family_page() {
        String actualTitle = pS_CreationPage.getPageTitle();
        String expectedTitle = "osc002_22";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

        System.out.println("Current page Title: " + actualTitle);

    }

    @Then("user click on CarFamily validate btn")
    public void user_click_on_CarFamily_validate_btn() {
        pS_CreationPage.CarfamilyValidate();
    }

    @Then("user select the versioncode check box")
    public void user_select_the_versioncode_check_box() throws Exception {
        pS_CreationPage.VersionCheckBoxes();
        // pS_CreationPage.ModificationFoundVersionList();
    }

    @Then("user click on add this versions into pf study")
    public void user_click_on_add_this_versions_into_pf_study() throws Exception {
        pS_CreationPage.ModificationAddVersionsPS();
    }

    @Then("^user send the volume numbers(.*)")
    public void user_send_the_volume_numbers2(String volumes) throws Exception {
        pS_CreationPage.ModificationSendVolumenum(volumes);
    }

    @Then("user click on save this profitability study for modification")
    public void user_click_on_save_this_profitability_study_for_modification() throws Exception {
        pS_CreationPage.ModificationSavePF();

    }

    @Then("user able to see the pfs number")
    public void user_able_to_see_the_pfs_number() {
        pS_CreationPage.pfstudyNumber();
    }

    @Then("user click on history Link text")
    public void user_click_on_history_Link_text() {
        pS_CreationPage.HistoryLnkBtn();
    }

    @And("user click on back button1")
    public void user_click_on_back_button1() {
        pS_CreationPage.BackBts();

    }

    @Then("user click on cancel modification btn")
    public void user_click_on_cancel_modification_btn() {
        pS_CreationPage.CancelModification();
    }

    @Then("user click on see version")
    public void user_click_on_see_version() {
        pS_CreationPage.SeeVersionLnkBtn();
    }

    @And("user click on the back button2")
    public void user_click_on_the_back_button2() {
        pS_CreationPage.BackBts();
    }

    @Then("user clcik on copy Link text")
    public void user_clcik_on_copy_link_text() {
        pS_CreationPage.CopyLnkBtn();
    }

    @Then("^user enter status code01(.*)")
    public void user_enter_status_code01(String scode) throws Exception {
        pS_CreationPage.SelectStatus(scode);
    }

    @And("user click on validate button1")
    public void user_click_on_validate_button1() throws Exception {
        pS_CreationPage.Validationbtn();

    }

    @And("user click on search")
    public void user_click_on_search() throws Exception {
        pS_CreationPage.SelectMouseover();
    }

    @Then("user able to see the Profitability study search page")
    public void user_able_to_see_the_profitability_study_search_page() {
        pS_CreationPage.TextOfPfSearch();
    }

    @Then("user click on Quick search")
    public void user_click_on_quick_search() throws Exception {
        pS_CreationPage.QuickSearch();
    }

    @Then("user enter pfs")
    public void user_enter_pfs() throws Exception {
        pS_CreationPage.PFSNum();
    }

    @Then("user click on start searching")
    public void user_click_on_start_searching() throws Exception {
        pS_CreationPage.Startsearching();
    }

    @Then("user stores the Pfs Number")
    public void user_stores_the_pfs_number() throws Exception {
        pS_CreationPage.storePfsNumber();
    }

    @And("user click on code")
    public void user_click_on_code() throws Exception {
        pS_CreationPage.SelectCodes();
    }

    @Then("user select the subsidiary data from reference table")
    public void user_select_the_subsidiary_data_from_reference_table() throws Exception {
        pS_CreationPage.RTable();
    }

//    @Then("user select the Subsidiary Data country")
//    public void user_select_the_subsidiary_data_country(List<List<String>> rtcountrys) throws Exception {
//        pS_CreationPage.SelectRTCountry(rtcountrys);
//    }
    @Then("user select the Subsidiary Data country")
    public void user_select_the_subsidiary_data_country(List<List<String>> rtcountrys) throws Exception {
        pS_CreationPage.SelectRTCountry(rtcountrys);
    }

    @Then("user select the provisinol rate")
    public void user_select_the_provisinol_rate() throws Exception {

        pS_CreationPage.ProvisionalRates();
    }

    @And("user check the searching for the provisional rates")
    public void user_check_the_searching_for_the_provisional_rates() throws Exception {
        pS_CreationPage.SearchPrrate();
    }

    @Then("user select the add new  line")
    public void user_select_the_add_new_line() throws Exception {

        pS_CreationPage.AddLine();
    }

    @Then("user validate the new line")
    public void user_validate_the_new_line() throws Exception {

        pS_CreationPage.ValidatePrRate();
    }

    @Then("user select the network remuneration section")
    public void user_select_the_network_remuneration_section() throws Exception {
        pS_CreationPage.NetWorkRm();
    }

    @Then("user click create new file option")
    public void user_click_create_new_file_option() {
        pS_CreationPage.CnewLine();
    }

//    @Then("user select country and modelrange")
//    public void user_select_country_and_modelrange() {
//    }
    @Then("user select country")
    public void user_select_country(List<List<String>> rtcountrys) throws Exception {
        // pS_CreationPage.NRCountry();
        pS_CreationPage.SelectRTCountry(rtcountrys);
    }

//    @Then("user select modelrange")
//    public void user_select_modelrange(List<List<String>> modelrange) throws Exception {
//        pS_CreationPage.MRangeee(modelrange);
//
//    }
    @Then("user select modelrange")
    public void user_select_modelrange() throws Exception {
        pS_CreationPage.MRangeee();

    }

//    @Then("user select engine")
//    public void user_select_engine(List<List<String>> rtengine) throws Exception {
//        pS_CreationPage.Engines(rtengine);
//    }
    @Then("user select engine")
    public void user_select_engine() throws Exception {
        pS_CreationPage.Engines();
    }

    @And("^user send the percentage(.*) and amount(.*)")
    public void user_send_the_percentage_and_amount(String per, String amt) throws Exception {
        pS_CreationPage.AmtPer(per, amt);
    }

    @Then("user can validatenrr")
    public void user_can_validatenrr() throws Exception {
        pS_CreationPage.ValidatedNrr();
    }

    @Then("user click on back")
    public void user_click_on_back() {
        pS_CreationPage.Backbtn();

    }

//    @Then("user select the country and modelrange and Engine")
//    public void user_select_the_country_and_modelrange_and_Engine(List<List<String>> nrcountrys) throws Exception {
//        pS_CreationPage.Selectcmrange(nrcountrys);
//    }

    @Then("user select the country and modelrange and Engine")
    public void user_select_the_country_and_modelrange_and_Engine() throws Exception {
        pS_CreationPage.Selectcmrange();
    }
//    }
//
//    @Then("user select the model range for NR")
//    public void user_select_the_model_range_for_NR(List<List<String>> nrfamilycode) throws Exception {
//        pS_CreationPage.SelectNRmodelrange(nrfamilycode);
//    }
//
//    @Then("user select the engine for NR")
//    public void user_select_the_engine_for_NR(List<List<String>> nrengine) throws Exception {
//        pS_CreationPage.SelectNREngine(nrengine);
//    }

    @And("user click on searechnr")
    public void user_click_on_searechnr() {
        pS_CreationPage.SearnchNrr();
    }

    @When("user select the Network remaining margin in RT")
    public void user_select_the_Network_remaining_margin_in_RT() throws Exception {
        pS_CreationPage.Networkmargin();

    }

    @And("^user enters the nm perc(.*)")
    public void user_enters_the_nmp_erc(String perc) throws Exception {
        pS_CreationPage.NMpage(perc);

    }

    @Then("user select the Friction factor in RT")
    public void user_select_the_friction_factor_in_rt() throws Exception {
        pS_CreationPage.Frictionf();
    }

    @And("user select the Budget RBCV from RT")
    public void user_select_the_budget_rbcv_from_rt() throws Exception {
        pS_CreationPage.RBCVFamily();
    }

    @Then("user select the International customer volume bonus from RT")
    public void user_select_the_international_customer_volume_bonus_from_rt() throws Exception {
        pS_CreationPage.InternationalB();
    }

    @And("user click on searchib")
    public void user_click_on_searchib() {
        pS_CreationPage.SearchIB();
    }

    @And("user click on searchib in Reference Table")
    public void user_click_on_searchib_in_reference_table() throws Exception {

        pS_CreationPage.searchReferenceIB();
    }

    @Then("user click on addnewline ib")
    public void user_click_on_addnewline_ib() {
        pS_CreationPage.Addnewlineib();
    }

    @Then("^user enter description(.*) and amount(.*)")
    public void user_enter_description_description_and_amount_amount(String description, String amount) throws Exception {
        pS_CreationPage.Ibdescription(description);
        pS_CreationPage.Ibamounts(amount);

    }

    @And("user click on validateib")
    public void user_click_on_validateib() throws Exception {
        pS_CreationPage.ValidateIB();
    }

    @Then("user click on International Bonus seacrh")
    public void user_click_on_international_bonus_search() throws Exception {

        pS_CreationPage.verifyInternationalSearch();
    }

    @Then("user select the Leasers International Bonus on volume from RT")
    public void user_select_the_leasers_international_bonus_on_volume_from_rt() throws Exception {
        pS_CreationPage.Leasers();
    }

//    @Then("^user enteres the customer Data(.*)")
//    public void user_enteres_the_customer_Data(String data) throws Exception {
//        pS_CreationPage.SearchDatavalue(data);
//    }
    @Then("user enteres the customer Data")
    public void user_enteres_the_customer_Data() throws Exception {
        pS_CreationPage.SearchDatavalue();
    }

//    @Then("^user enter description(.*) and amount(.*)")
//    public void user_enter_description_description_and_amount_amount(String description, String amount) throws Exception {
//        pS_CreationPage.Ibdescription(description);
//        pS_CreationPage.Ibamounts(amount);
//
    // }

    @Then("user click on Leasers International Bonus seacrh")
    public void user_click_leasers_international_bonus_search() throws Exception {
        pS_CreationPage.verifyleaserInternationalSearch();
    }

    @Then("user select the user configuration on contrib administration")
    public void user_select_the_user_configuration_on_contrib_administration() throws Exception {
        pS_CreationPage.ContribA();
    }

    @Then("user can select the contrib lock from CA")
    public void user_can_select_the_contrib_lock_from_ca() throws Exception {
        pS_CreationPage.ContribLock();

    }

    @Then("user select the translation from CA")
    public void user_select_the_translation_from_ca() throws Exception {
        pS_CreationPage.TranslationCa();
    }

//    @Then("user select the language and click on add")
//    public void user_select_the_language_and_click_on_add(List<List<String>> slang) throws Exception {
//        pS_CreationPage.Slang(slang);
//    }
//
//    @Then("user select the add language")
//    public void user_select_the_add_language(List<List<String>> slangs) throws Exception {
//        pS_CreationPage.Slangs(slangs);
//    }

//    @Then("user click on On-line publishing")
//    public void user_click_on_on_line_publishing() {
//
//    }

    @Then("user select the Application Messages from CA")
    public void user_select_the_application_messages_from_ca() throws Exception {
        pS_CreationPage.ApplicationMessage();
    }

    @Then("user select the purge version from CA")
    public void user_select_the_purge_version_from_ca() throws Exception {
        pS_CreationPage.Purge();
    }

//    @Then("user select search and versions")
//    public void user_select_search_and_versions(List<List<String>> purgevv) throws Exception {
//
//        pS_CreationPage.PurgeVersions(purgevv);
//    }
    @Then("user select search and versions")
    public void user_select_search_and_versions() throws Exception {

        pS_CreationPage.PurgeVersions();
    }

    @Then("user select the filing option from CA")
    public void user_select_the_filing_option_from_ca() throws Exception {
        pS_CreationPage.FilingPS();
    }

    @Then("user click on multicreteria country and Activity")
    public void user_click_on_multicreteria_country_and_activity(List<List<String>> multicriteria) throws Exception {
        pS_CreationPage.SelectMutlic(multicriteria);
    }

    @Then("^user enter pfs no(.*)")
    public void user_enter_pfs(String pfs) throws Exception {
        pS_CreationPage.Psnumber1(pfs);
    }

    @Then("user click on yellow arrow button")
    public void user_click_on_yellow_arrow_button() throws Exception {
        pS_CreationPage.clickYellowArrowButton();
    }

    @Then("user select the client")
    public void user_select_the_client() throws Exception {
        pS_CreationPage.SelecttClient();
    }

//    @Then("user enter pfs no")
//    public void user_enter_pfs_no() throws Exception {
//        pS_CreationPage.Psnumber();

    // }

    @Then("^user enter pfs number(.*)")
    public void user_enter_pfs_number(String pfs) throws Exception {
        pS_CreationPage.Psnumber1(pfs);

    }
//    @Then("user enter pfs number")
//    public void user_enter_pfs_number() throws Exception {
//        pS_CreationPage.Psnumbers();
//
//    }

    @When("user click on archiveS")
    public void user_click_on_archive() throws Exception {

        pS_CreationPage.Archivebtn();
    }

    @Then("user click on unarchive")
    public void user_click_on_unarchive() throws Exception {
        pS_CreationPage.Unarchivebtn();

    }

    @Then("user select the Profitability study removal from CA")
    public void user_select_the_profitability_study_removal_from_ca() throws Exception {
        pS_CreationPage.PfRemoval();
    }

    @And("user click on checkbox of ps removal")
    public void user_click_on_checkbox_of_ps_removal() throws Exception {
        pS_CreationPage.Checkpf();
    }

    @Then("user select the creation of manual version from CA")
    public void user_select_the_creation_of_manual_version_from_ca() throws Exception {
        pS_CreationPage.CheckManualVersion();
    }

    @Then("user select the budget RBCV Family from CA")
    public void user_select_the_budget_rbcv_family_from_ca() throws Exception {
        pS_CreationPage.RBCVIntegration();
    }

    @Then("user click on similar versions")
    public void user_click_on_similar_versions() {
        pS_CreationPage.SimilarVer();
    }

    @Then("user click on History")
    public void user_click_on_history() throws Exception {
        pS_CreationPage.Historybtn();
    }

    @Then("user click on back button")
    public void user_click_on_back_button() {
        pS_CreationPage.BackBts();
    }

    @And("user click on see versions")
    public void user_click_on_see_versions() throws Exception {
        pS_CreationPage.SeeVersion();
    }

    @Then("user click on copy")
    public void user_click_on_copy() throws Exception {
        pS_CreationPage.Copybtns();
    }

    @Then("user click on modify history")
    public void user_click_on_modify_history() throws Exception {
        pS_CreationPage.ModifyHistorybtn();
    }

    @Then("user click on modify add version")
    public void user_click_on_modify_add_version() throws Exception {
        pS_CreationPage.ModifyAddVersion();
    }

    @Then("user click on modify see versions")
    public void user_click_on_modify_see_versions() throws Exception {
        pS_CreationPage.ModifySeeVersions();
    }

    @And("user click on Refresh pstudy")
    public void user_click_on_refresh_pstudy() throws Exception {
        pS_CreationPage.Refreshbtn();
    }

    @Then("user click validate refreshbtn")
    public void user_click_validate_refreshbtn() throws Exception {
        pS_CreationPage.ValidRefresh();
    }

    @Then("user click on Estimated rate radio button")
    public void user_click_on_Estimated_rate_radio_button() throws Exception {
        pS_CreationPage.EstimaterateRadioBtn();

    }

    @Then("user click on Estimated rate Textlink")
    public void user_click_on_Estimated_rate_Textlink() {
        pS_CreationPage.EstimatedRate();
    }

    @And("user click on cancel button")
    public void user_click_on_cancel_button() throws Exception {
        pS_CreationPage.CancelEstimaterate();
    }

    @Then("user click on copy data")
    public void user_click_on_copy_data() throws Exception {
        pS_CreationPage.CopyDataa();
    }

    @And("user click on paste")
    public void user_click_on_paste() throws Exception {
        pS_CreationPage.PasteeDataa();
    }

    @Then("user click Refresh version")
    public void user_click_Refresh_version() throws Exception {
        pS_CreationPage.RefreshVers();

    }

    @Then("user click on Version Validate")
    public void user_click_on_Version_Validate() throws Exception {
        pS_CreationPage.ValidateRefresh();

    }

    @Then("user click on Recalculate version")
    public void user_click_on_recalculate_version() throws Exception {
        pS_CreationPage.RecalculateVersion();
    }

    @And("user click on Add options")
    public void user_click_on_add_options() throws Exception {
        pS_CreationPage.AddOptionss();
    }

    @Then("user click on Subsidiary bonuses")
    public void user_click_on_subsidiary_bonuses() {
        pS_CreationPage.SubsidaryData();
    }

    @And("user click on add line")
    public void user_click_on_add_line() throws Exception {
        pS_CreationPage.Addnewlinesub();
    }

    @Then("^user enter subdescription(.*) and subamount(.*)")
    public void user_enter_subdescription_and_subamount(String subdescription, String subamount) throws Exception {
        pS_CreationPage.enterSubDetailsInLatestRow(subdescription, subamount);
        // pS_CreationPage.Subamounts(subamount);
    }

    @Then("user click on modify Header")
    public void user_click_on_modify_header() throws Exception {
        pS_CreationPage.ModifyHeaderbtn();
    }

    @Then("^user change the status code(.*)")
    public void user_change_the_status_code(String mscode) throws Exception {
        pS_CreationPage.ModiStatusCode(mscode);
    }

    @Then("user click on Application Maintenance")
    public void user_click_on_application_maintenance() throws Exception {
        contribApplicationMaintenancePage.applicationMaintainance();

    }

    @Then("user should enters the Title message")
    public void user_should_enters_the_title_message() {
        contribApplicationMaintenancePage.enterMessageTitle();
    }

    @Then("user should enters the Message body")
    public void user_should_enters_the_message_body() {
        contribApplicationMaintenancePage.enterMessageBody();
    }

    @Then("user click on start date")
    public void user_click_on_start_date() throws Exception {
        contribApplicationMaintenancePage.startDate();
    }

    @Then("user click on End date")
    public void user_click_on_end_date() throws Exception {
        contribApplicationMaintenancePage.endDate();
    }

    @Then("user click on Schedule")
    public void user_click_on_schedule() throws Exception {
        contribApplicationMaintenancePage.schedule();
    }

    @Then("user verify the HomePage Texts")
    public void user_verify_the_homepage_texts() throws Exception {
        contribApplicationMaintenancePage.homePageverification();
    }

    @Then("user verify The Scheduled sections")
    public void user_verify_the_scheduled_sections() {
        contribApplicationMaintenancePage.verifyScheduledSections();
    }

    @Then("user verify The Status colum")
    public void user_verify_the_status_colum() {
        contribApplicationMaintenancePage.printStatusColumn();
    }

    @Then("user verify the welecome contrib")
    public void user_verify_the_welcome_contrib() throws Exception {
        contribApplicationMaintenancePage.printWelcomeContrib();
    }

    @Then("verify getsupport hyperlink")
    public void verify_getsupport_hyperlink() {
        contribApplicationMaintenancePage.verifyGetSupport();
    }

    @Then("verify CONTRIB Guide hyperlink")
    public void verify_contrib_guie_hyperlink() {
        contribApplicationMaintenancePage.verifyContribGuide();
    }

    @Then("verify home page text")
    public void verify_homepage_text() {
        contribApplicationMaintenancePage.verifyWelcomeContrib();

    }

    @Then("user verify the logo of brand")
    public void user_verify_the_logo_brand() {
        contribApplicationMaintenancePage.verifyBrandLogoAfterClick();

    }

    @Then("user verify one brand is selected")
    public void user_verify_on_brand_is_selected() throws Exception {
        contribApplicationMaintenancePage.countBrandsThenClickAndPrint();
    }

    @Then("user verify that logos for all brands are displayed on the Home Page correctly")
    public void user_verify_that_logos_for_all_brands_are_displayed_on_the_home_page_correctly() {
        contribApplicationMaintenancePage.verifyHomePageBrandBehavior();
    }

    @Then("the correct logo should be displayed for each CONTRIB brand on the Home Page")
    public void the_correct_logo_should_be_displayed_for_each_contrib_brand_on_the_home_page() {
        contribApplicationMaintenancePage.verifyBrandLogosOnHomePage();
    }

    @Then("Verify that the  Welcome to CONTRIB  hyperlink")
    public void verify_that_the_welcome_to_contrib_hyperlink() throws Exception {
        contribApplicationMaintenancePage.verifyWelcomeToContribHyperlink();
    }

    @Then("Verify that real-time status indicators are displayed and updated correctly on the home page")
    public void verify_that_real_time_status_indicators_are_displayed_and_updated_correctly_on_the_page() throws Exception {
        contribApplicationMaintenancePage.verifyRealTimeStatusIndicator();
    }
}
