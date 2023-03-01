Feature: login to the OrangeHRM

  Background: Login and Logout from OrangeHRM
   Given User is Open the OrangeHRM website
    When User is entering the UserName and Password , click on login button
    Then Close the OrangeHRM and Open the EasyMyTrip
 @tag1
  Scenario Outline: User ia able to Book the Flight in EasyTrip Website
    Given User is able to launch the EasyMyTrip Website
    When User is select the source "<Source>" and destination "<Destination>"
    And select the Departure date and Return Date
    And passenger details adults  and childs  and click on Search
    Then verify the Booking Page and close the Browser

    Examples: 
      | Source         | Destination |
      | Bangalore(BLR) | Goa(GOI)    |

	@tag2
  Scenario: User is able to Book online Bus tickets on EasymyTrip
    Given User is able to launch the EasyMyTrip Website
    When User is select the Source and Destination, Date click on Search
    When slecect the bus and BoardingPoint and DropingPoint click on Continue
    Then Verify the Bus BookingPage and Close the browser

	@tag3
  Scenario Outline: User is able to book online Traintickets
    Given User is able to launch the EasyMyTrip Website
    When User is select the from "<from>" and to "<to>"
    And select Departuredate click Search
    And Select the Coach and Book click on continue
    Then Verify the BookingPage and close the website

    Examples: 
      | from                    | to                  |
      | Bengaluru- All Stations | Delhi- All Stations |
