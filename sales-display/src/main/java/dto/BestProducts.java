package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.primefaces.model.charts.pie.PieChartModel;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestProducts implements Serializable {

    private static String UNITS_SOLD_CHART_LABEL = "Units sold by genre";
    private static String PROFIT_CHART_LABEL = "Profit by genre";

    private PieChartModel unitsSoldByGenre;
    private PieChartModel profitByGenre;
    private List<Product> topProductsList;

}
