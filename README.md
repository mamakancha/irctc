### IRCTC Prototype :

This project is built using **Java(11) + Springboot(2.5)**.

I've used MVC pattern. Overall, any API being called hits the Controller layer which further delegates the business logic to Service layer to maintain separation of concern. All the data is being access via DAO layer.

Instead of keeping data in memory or using a DB , I've used csv files as proxy DB to give better idea about the data.

For now, there's no validation based on user roles. ( Some of the basic validations might be missing as well ).

The project supports limited functionalities for now. 

_**Supported APIs:**_

`/train/getAllTrains`

`/train/getTrainByCity?startCity=startCityName&destinationCity=destinationCityName`


`/booking/getAllBookingsByUser?userID=userID`

`/booking/saveBooking?userID=userID&trainJourneyID=trainJourneyID&totalPrice=totalPrice`