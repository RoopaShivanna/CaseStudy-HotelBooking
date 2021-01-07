Feature: Hotel Booking Form Validation

Scenario: Login to the Hotel Booking Application

Given user opens browser
When user is on login page
When user clicks on login button without entering username/password display error message
Then user logged into the application after entering proper credentials

Scenario: Hotel Booking form fill

Given user is on hotel booking form page
When user doesnot enter firstname and clicks on confirm booking
When user doesnot enter lastname and clicks on confirm booking
When user enter wrong email and clicks on confirm booking
When user enters  valid and invalid Phone number
    | 5678765473 |
    | 57654389 |
    | 786545674327 |
    | 9656543789 |
When user clicks on confirm booking without selecting city
When user clicks on confirm booking without selecting state
When user clicks on confirm booking without entering card holder name
When user clicks on confirm booking without entering debit card number
| 5555444444444444 |
|123|
When user clicks on confirm booking without entering expiration month
|09|
When user clicks on confirm booking without entering expiration year
|2023|


When user enters all the required deatils
  
Then user successfully booked the hotel



