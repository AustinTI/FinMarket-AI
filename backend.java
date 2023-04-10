// Here's a consolidated Java Spring Boot backend code that includes both the 
// StockMarketDataService and StockDataController classes, as well as a StockData model for demonstration purposes.
// This is consolidated Java Spring Boot backend code that includes both the StockMarketDataService and StockDataController classes, as well as a StockData model.

package com.example.stockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StockAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockAppApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/stocks")
class StockDataController {

    @Autowired
    private StockMarketDataService stockMarketDataService;

    @GetMapping("/{marketCap}")
    public ResponseEntity<List<StockData>> getTopStocksByMarketCap(@PathVariable String marketCap) {
        List<StockData> stocks = stockMarketDataService.getTopStocksByMarketCap(marketCap, 25);
        return ResponseEntity.ok(stocks);
    }
}

@Service
public class StockMarketDataService {

    private static final String FINNHUB_API_KEY = "YOUR_FINNHUB_API_KEY";
    private static final String POLYGON_API_KEY = "YOUR_POLYGON_API_KEY";
    private static final String ALPHAVANTAGE_API_KEY = "YOUR_ALPHAVANTAGE_API_KEY";
    private static final String BARCHART_API_KEY = "YOUR_BARCHART_API_KEY";

    private RestTemplate restTemplate = new RestTemplate();

    // Method to fetch and process stock data
    public List<StockData> getTopStocksByMarketCap(String marketCap, int limit) {
        List<StockData> stocks = new ArrayList<>();

        // Fetch and process data from each API
        fetchAndProcessFinnhubData(marketCap, limit, stocks);
        fetchAndProcessPolygonData(marketCap, limit, stocks);
        fetchAndProcessAlphaVantageData(marketCap, limit, stocks);
        fetchAndProcessBarChartData(marketCap, limit, stocks);

        // Filter, sort, and limit the stocks according to your requirements

        return stocks;
    }

    private void fetchAndProcessFinnhubData(String marketCap, int limit, List<StockData> stocks) {
        // Implement Finnhub.io API calls and data processing here
        // Add processed data to the stocks list
    }

    private void fetchAndProcessPolygonData(String marketCap, int limit, List<StockData> stocks) {
        // Implement Polygon.io API calls and data processing here
        // Add processed data to the stocks list
    }

    private void fetchAndProcessAlphaVantageData(String marketCap, int limit, List<StockData> stocks) {
        // Implement AlphaVantage.com API calls and data processing here
        // Add processed data to the stocks list
    }

    private void fetchAndProcessBarChartData(String marketCap, int limit, List<StockData> stocks) {
        // Implement BarChart.com API calls and data processing here
        // Add processed data to the stocks list
    }
}

class StockData {
    private String ticker;
    private String companyName;
    private long volumePreMarket;
    private long volumeToday;
    private double high52Week;
    private double low52Week;

    // Constructor, getters, and setters
}
