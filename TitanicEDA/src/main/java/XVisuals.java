import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;


public class XVisuals
{

	public static void graphPassengerAges(List<TitanicPassenger> passengerList) {
		List<Float> pAges = passengerList.stream ().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList ());
		List<String> pNames = passengerList.stream ().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList ());

		CategoryChart chart = new CategoryChartBuilder().width (1024).height(768)
				.title("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();

		chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
		chart.getStyler().setHasAnnotations (true);
		chart.getStyler().setStacked (true);

		chart.addSeries ("Passenger's Ages", pNames, pAges);

		new SwingWrapper(chart).displayChart ();
	}
	public static void graphPassengerClass(List<TitanicPassenger> passengerList) 
	{
		Map<String, Long> result = passengerList.stream()
				.collect(Collectors.groupingBy(TitanicPassenger::getPclass,Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width (800).height (600).title("Passenger Class").build ();

		Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
		chart.getStyler ().setSeriesColors (sliceColors);

		chart.addSeries ("First Class", result.get ("1"));
		chart.addSeries ("Second Class", result.get ("2"));
		chart.addSeries ("Third Class", result.get ("3"));
		new SwingWrapper (chart).displayChart ();
	}
	public static void graphPassengersurvived(List<TitanicPassenger> passengerList)
	{
	 
		Map<String, Long> result = passengerList.stream()
				.collect(Collectors.groupingBy(TitanicPassenger::getSurvived,Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width(800).height (600).title("Passenger Survived").build ();

		Color[] sliceColors = new Color[]{new Color (100, 190, 50), new Color (70, 75, 120) };
		chart.getStyler ().setSeriesColors (sliceColors);
		chart.addSeries ("Survived", result.get ("1"));
		chart.addSeries ("Didn't Survive", result.get ("0"));

		new SwingWrapper (chart).displayChart();
	}
	public static void graphPassengersurvivedGender(List<TitanicPassenger> passengerList)
	{
		 
		Map<String, Long> result = passengerList.stream().filter(k-> "1".equals(k.getSurvived())  )
				.collect(Collectors.groupingBy(TitanicPassenger::getSex,Collectors.counting()));
		
		PieChart chart = new PieChartBuilder().width(800).height (600).title("Male/Female Survived").build ();

		Color[] sliceColors = new Color[]{new Color (120, 130, 200), new Color (200, 95, 170) };
		chart.getStyler ().setSeriesColors (sliceColors);

		chart.addSeries ("Male Survived", result.get ("male"));
		chart.addSeries ("Female Survive", result.get ("female"));

		new SwingWrapper(chart).displayChart();
	}
}
