package com.magnatron.CountriesVizualization;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.math.MathContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import org.knowm.xchart.*;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.internal.chartpart.Annotation;
import org.knowm.xchart.style.AxesChartStyler.TextAlignment;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.markers.Marker;
import org.knowm.xchart.style.theme.MatlabTheme;
import org.knowm.xchart.style.theme.Theme;

import countriesdata.City;
import countriesdata.Country;

public class Scatter_x 
{
	  public static PieChart getCityPieChart(List<City> mapper) 
	  {
		    // Create Chart
		    PieChart chart = new PieChartBuilder().width(800).height(600).theme(ChartTheme.Matlab).title("PieChart").build();
		    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
			chart.getStyler().setHasAnnotations(true);
		    // Customize Chart
 
		    Color[] sliceColors = new Color[mapper.size()];
		    float increment =  mapper.size()/360.0f ;
		    float accumulator = 0;
		     
		    for(int i = 0; i < sliceColors.length; i++)
		    {
		    	accumulator += increment;
		    	sliceColors[i] = Color.getHSBColor( 1-accumulator/5 ,  0.5f,0.9f);
		    }

 		    chart.getStyler().setSeriesColors(sliceColors);
		    mapper.forEach(cc -> chart.addSeries(cc.getName(), cc.getPopulation()));

	    return chart;
	  }
	  
 
	  public static CategoryChart getBarChart(List<Country> mapper) 
	  {
	    // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).theme(ChartTheme.Matlab).title("World Histogram").xAxisTitle("Country").yAxisTitle("Population").build();
	 
	    // Customize Chart
	    chart.setCustomYAxisTickLabelsFormatter(y -> (double)y + "mil");
	    chart.getStyler().setDecimalPattern("#0.0");
	    chart.getStyler().setLegendPosition(LegendPosition.OutsideS);
	    chart.getStyler().setHasAnnotations(false);
	    chart.getStyler().setAnnotationsFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
	    chart.getStyler().setAnnotationsFontColor(new Color(0,0,0,0.4f));
	    chart.getStyler().setAntiAlias(true);
	    chart.getStyler().setAnnotationsRotation(90);
	    

	    chart.getStyler().setAxisTickLabelsFont(new Font(Font.DIALOG, Font.BOLD,8));
	    chart.getStyler().setYAxisMax(1300d);
	    chart.getStyler().setYAxisTitleColor(new Color(55,0,0));
	    chart.setCustomXAxisTickLabelsFormatter(k  -> mapper.get(k.intValue()).getCountryCode() );
	    chart.getStyler().setXAxisLabelRotation(90);
	    double[] l_population = mapper.stream().mapToDouble(sc -> sc.getPopulation()/1000000.0f).toArray();
	    double[] x_axis  =  IntStream.range(0, l_population.length).asDoubleStream().toArray();
	     
	    chart.addSeries("Population (in millions)",x_axis,l_population);
 
	    return chart;
	  }
}
