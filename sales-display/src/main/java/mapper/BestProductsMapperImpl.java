package mapper;

import dto.BestProducts;
import dto.ProductStats;
import util.PieChart;

import javax.inject.Singleton;

@Singleton
public class BestProductsMapperImpl implements BestProductsMapper {

    private String UNITS_SOLD_CHART_LABEL = "Units sold by genre";
    private String PROFIT_CHART_LABEL = "Profit by genre";

    @Override
    public BestProducts toBestProducts(ProductStats productStats) {
        if (productStats == null) {
            return null;
        }

        BestProducts bestProducts = new BestProducts();
        bestProducts.setTopProductsList(productStats.getTopProducts());

        bestProducts.setProfitByGenre( PieChart.getPieChartModel(PROFIT_CHART_LABEL, productStats.getProfitByGenre()) );
        bestProducts.setUnitsSoldByGenre( PieChart.getPieChartModel(UNITS_SOLD_CHART_LABEL, productStats.getUnitsSoldByGenre()) );

        return bestProducts;
    }
}
