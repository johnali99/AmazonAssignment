Feature: Kindle

@testRun
Scenario: Verify that user is prompt to provide email or phone number when clicking on Buy Now button
		Given user is on Amazon website
		And user click on hamburger menu
		And user select Kindle under Digital Content and Devices
		And user click Kindle under Kindle E-Reader
		And user click Buy Now
		Then user should see "E-mail address or mobile phone number" text