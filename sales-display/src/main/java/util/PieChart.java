package util;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.pie.PieChartOptions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PieChart {

    private static final String[] colors = new String[]{"rgb(72, 143, 49)", "rgb(150, 172, 90)", "rgb(210, 202, 144)",
                                                 "rgb(255, 237, 207)", "rgb(241, 186, 143)", "rgb(229, 129, 99)",
                                                 "rgb(222, 66, 91)"};

    private static final int maxNumberOfSections = colors.length;

    public static PieChartModel getPieChartModel(String title, HashMap<String, ? extends Number> data) {
        List<Number> values = new ArrayList<>(data.values());
        List<String> labels = new ArrayList<>(data.keySet());

        return getPieChartModel(title, values, labels);
    }

    public static PieChartModel getPieChartModel(String title, List<Number> values, List<String> labels) {
        PieChartModel pieModel = new PieChartModel();
        pieModel.setOptions( options(title) );
        pieModel.setData( chartData(values, labels) );

        return pieModel;
    }

    private static ChartData chartData(List<Number> values, List<String> labels) {
        if (maxNumberOfSections < values.size()) {
            return chartDataMaxNumberOfSectionsExceeded(values, labels);
        } else {
            return regularChartData(values, labels);
        }
    }

    private static List<String> sortLabelsByValues(List<Number> values, List<String> labels) {
        Map<String, Number> hashMap = IntStream.range(0, values.size())
                                                .boxed()
                                                .collect(Collectors.toMap(labels::get, values::get));

        List<Map.Entry<String, Number>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(  Collections.reverseOrder(Comparator.comparingDouble(o -> o.getValue().doubleValue()))  );

        return list.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static ChartData chartDataMaxNumberOfSectionsExceeded(List<Number> values, List<String> labels) {
        List<String> sortedLabels = sortLabelsByValues(values, labels);

        List<Number> sortedValues = new ArrayList<>(values);
        sortedValues.sort(Collections.reverseOrder(Comparator.comparingDouble(Number::doubleValue)) );

        double otherValue = 0;
        String otherLabel = "Other";

        for (int i = maxNumberOfSections - 1; i < sortedValues.size(); i++) {
            otherValue = otherValue + sortedValues.get(i).doubleValue();
        }

        List<Number> newValues = sortedValues.subList(0, maxNumberOfSections - 1);
        List<String> newLabels = sortedLabels.subList(0, maxNumberOfSections - 1);

        newValues.add(otherValue);
        newLabels.add(otherLabel);

        return regularChartData(newValues, newLabels);
    }

    private static ChartData regularChartData(List<Number> values, List<String> labels) {
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();

        dataSet.setData(values);
        dataSet.setBackgroundColor( chartColors(values.size()) );

        data.addChartDataSet(dataSet);
        data.setLabels(labels);

        return data;
    }

    private static List<String> chartColors(int numberOfSections) {
        String[] colors = Arrays.copyOf(PieChart.colors, numberOfSections);
        return Arrays.asList(colors);
    }

    private static PieChartOptions options(String titleText) {
        PieChartOptions options = new PieChartOptions();

        // title
        Title title = title(titleText);
        options.setTitle(title);

        // legend
        Legend legend = legend();
        options.setLegend(legend);

        return options;
    }

    private static Title title(String titleText) {
        Title title = new Title();
        title.setText(titleText);
        title.setDisplay(true);

        return title;
    }

    private static Legend legend() {
        Legend legend = new Legend();
        legend.setPosition("left");

        return legend;
    }

}
