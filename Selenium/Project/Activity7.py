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

        mydetails = self.driver.find_element(By.ID, "menu_pim_viewMyDetails")
        mydetails.click()
        WebDriverWait(self.driver, 10).until(EC.presence_of_element_located((By.LINK_TEXT, "Qualifications")))

        qualifications = self.driver.find_element(By.LINK_TEXT, "Qualifications")
        qualifications.click()

        workExperience = self.driver.find_element(By.ID, "addWorkExperience")
        workExperience.click()

        empCompany = self.driver.find_element(By.ID, "experience_employer")
        empCompany.send_keys("IBM")

        jobTitle = self.driver.find_element(By.ID, "experience_jobtitle")
        jobTitle.send_keys("Tester")

        save = self.driver.find_element(By.ID, "btnWorkExpSave")
        save.click()





