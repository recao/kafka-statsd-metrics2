package com.airbnb.metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.Metric;

public class StatsDMetricsRegistry {
  private final Map<String, Metric> name_metric;
  private final Map<String, String> name_dimensions;

  public StatsDMetricsRegistry() {
    name_metric= new HashMap<String, Metric>();
    name_dimensions = new HashMap<String, String>();
  }

  public void register(
    String metricName,
    Metric metric,
    String dimensions
  ) {
    name_metric.put(metricName, metric);
    name_dimensions.put(metricName, dimensions);
  }

  public void unregister(String metricName) {
    name_metric.remove(metricName);
    name_dimensions.remove(metricName);
  }

  public List<String> getMetricsName() {
    return new ArrayList<String>(name_metric.keySet());
  }

  public Metric getMetric(String metricName) {
    return name_metric.get(metricName);
  }

  public String getDimensions(String metricName) {
    return name_dimensions.get(metricName);
  }
}
