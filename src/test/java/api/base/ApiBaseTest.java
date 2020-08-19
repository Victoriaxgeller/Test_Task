package api.base;

import api.ApiClient;
import api.RetrofitSetup;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract public class ApiBaseTest {

    public ApiClient createApiClient() {
        return new ApiClient(createRetrofitClient());
    }

    private RetrofitSetup createRetrofitClient() {
        return new RetrofitSetup();
    }

    public static String generateRandomTestData() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
        return IntStream.range(0, 8).mapToObj(iteration -> {
            int character = (int) (Math.random() * 26);
            return alphabet.substring(character, character + 1);
        }).collect(Collectors.joining());
    }

}
