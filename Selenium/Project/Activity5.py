from selenium.webdriver.support import expected_conditions as EC

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait


# Create a fixture to initialize our webdriver
@pytest.fixture(scope="session")
def setup(request):
    # Initialize the webdriver
    driver = webdriver.Firefox()

    # Get the underlying collection
    session = request.node

    # Pass through the driver to the test class
    for item in session.items:
        cls = item.getparent(pytest.Class)
        setattr(cls.obj, "driver", driver)

    # Execute the test method
    yield

    # Close the browser once the test has ended
    request.addfinalizer(driver.close)


@pytest.mark.usefixtures("setup")
class TestSite:

    def test_orangeHRM(self):
        self.driver.get("http://alchemy.hguy.co/orangehrm")

        username = self.driver.find_element(By.ID, "txtUsername")
        password = self.driver.find_element(By.ID, "txtPassword")

        username.send_keys("orange")
        password.send_keys("orangepassword123")

        login = self.driver.find_element(By.ID, "btnLogin")
        login.click()

        welcomeMessage = self.driver.find_element(By.ID, "welcome").text
        print(welcomeMessage)

        myInfo = self.driver.find_element(By.ID, "menu_pim_viewMyDetails")
        myInfo.click()

        edit = self.driver.find_element(By.ID, "btnSave")
        edit.click()

        firstname = self.driver.find_element(By.ID, "personal_txtEmpFirstName")
        firstname.click()

        lastname = self.driver.find_element(By.ID, "personal_txtEmpFirstName")
        lastname.click()

        gender = self.driver.find_element(By.ID, "personal_optGender_2")
        gender.click()

        selectNationality = Select(self.driver.find_element(By.ID,"personal_cmbNation"))
        selectNationality.select_by_visible_text('British')

        dob = self.driver.find_element(By.ID, "personal_DOB")
        dob.clear()
        dob.send_keys("1995-02-02")

        save = self.driver.find_element(By.ID, "btnSave")
        save.click()
