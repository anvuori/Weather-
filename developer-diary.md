# INSIGHTS

## Comments about work

* I used too much time to get the client side work, when the main task was to create the server side. In the future I should remember to keep the side tasks more simple.
* Returning the weather data straight as a string made it pretty difficult to use. A better way to do that would be using [data transfer objects](https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application).
* The app wouldn't need user tracking or authentication if the favourite cities were saved locally to the client side [local storage](https://www.robinwieruch.de/local-storage-react/).
*



## Future Improvements

* React local storage to save favourite cities
* Better exception handling to the REST API
* Return Http Responses instead of strings in the REST API
* Return Data Transfer Objects instead of String
* A global state to react instead of component states
* Remove API key and Authentication client secret and replace it with a dummy
