package in.pradumn.newsweather_1.interfaces;

import in.pradumn.newsweather_1.responses.MashapeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by Pradumn on 28-Sep-16.
 */
public interface ApiService {
    @GET("topnews")
    Call<MashapeResponse> getTopStories(@Header("X-Mashape-Key") String key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDODBOekU1TVRRNExtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODYzZjdkNzE5NDU3")
    Call<MashapeResponse> getSportsNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHlPVFkxT0RreU9USXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODYzZjNiMWU4MDM5")
    Call<MashapeResponse> getWorldNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHhPRGs0TURVMUxtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODYzZjdkNzE5M2Q4")
    Call<MashapeResponse> getBusinessNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1Memt4TXpFMk9EZzBOaTVqYlhNL1ptVmxaSFI1Y0dVOWMycHpiMjQ9NTg2M2Y3ZDcxOTVmYw==")
    Call<MashapeResponse> getEducationNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHhNRGd4TkRjNU9UQTJMbU50Y3o5bVpXVmtkSGx3WlQxemFuTnZiZz09NTg2M2Y3ZDcxOTUwMg==")
    Call<MashapeResponse> getEntertainmentNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1MekkyTkRjeE5qTXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODYzZjdkNzE5NjM4")
    Call<MashapeResponse> getEnvironmentNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHRNakV5T0Rrek5qZ3pOUzVqYlhNL1ptVmxaSFI1Y0dVOWMycHpiMjQ9NTg2M2Y3ZDcxOTM1ZQ==")
    Call<MashapeResponse> getIndiaNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1MeTB5TVRJNE5qY3lOelkxTG1OdGN6OW1aV1ZrZEhsd1pUMXphbk52Ymc9PTU4NjNmN2Q3MTk2NzQ=")
    Call<MashapeResponse> getScienceNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDODFPRGd3TmpVNUxtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODYzZjdkNzE5NDFi")
    Call<MashapeResponse> getTechNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1MekU0T1RneU56UXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODY5M2QxMzU1ZTQ5")
    Call<MashapeResponse> getEuropeNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1Mekl4TnpnME16QXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODY5M2QxMzU1ZjM3")
    Call<MashapeResponse> getMadWorldNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1MekU0T1RneU56SXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODY5M2QxMzU1ZWJi")
    Call<MashapeResponse> getMiddleEastNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1Mek13TXpVNU5UTTBMbU50Y3o5bVpXVmtkSGx3WlQxemFuTnZiZz09NTg2OTNkMTM1NWQ5NQ==")
    Call<MashapeResponse> getPakistanNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1MelkzTVRNeE5DNWpiWE0vWm1WbFpIUjVjR1U5YzJwemIyND01ODY5M2QxMzU1ZWZk")
    Call<MashapeResponse> getRestOfWorldNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1Mek01TURjME1USXVZMjF6UDJabFpXUjBlWEJsUFhOcWMyOXU1ODY5M2QxMzU1ZGNm")
    Call<MashapeResponse> getSouthAsiaNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpHUm1Mek13TXpVNU5EZzJMbU50Y3o5bVpXVmtkSGx3WlQxemFuTnZiZz09NTg2OTNkMTM1NWQ1Yw==")
    Call<MashapeResponse> getUsNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHRNakV5T0Rrek1qUTFNaTVqYlhNL1ptVmxaSFI1Y0dVOWMycHpiMjQ9NTg2YmYyMmY0ODY2Yw==")
    Call<MashapeResponse> getCitiesNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDODNNRGs0TlRZekxtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODZiZjIyZjQ4OGZl")
    Call<MashapeResponse> getNriNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHhOemM0TVRrM05pNWpiWE0vWm1WbFpIUjVjR1U5YzJwemIyND01ODZiZjIyZjRkZDZl")
    Call<MashapeResponse> getTvNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHlNamMzTVRJNUxtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODZiZjIyZjRkZWE1")
    Call<MashapeResponse> getEventsNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);

    @GET("news?token=YUhSMGNEb3ZMM1JwYldWemIyWnBibVJwWVM1cGJtUnBZWFJwYldWekxtTnZiUzltWldWa2N5OXVaWGR6Wm1WbFpDOHlPRGcyTnpBMExtTnRjejltWldWa2RIbHdaVDF6YW5OdmJnPT01ODZiZjIyZjRlZWYz")
    Call<MashapeResponse> getLifeAndStyleNews(@Header("X-Mashape-Key") String Key, @Header("Accept") String accept);
}
