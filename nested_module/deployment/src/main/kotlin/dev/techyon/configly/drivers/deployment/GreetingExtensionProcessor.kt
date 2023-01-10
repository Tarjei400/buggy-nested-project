package dev.techyon.configly.drivers.deployment

import dev.techyon.configly.drivers.AdditionalLogHandlerValueFactory
import dev.techyon.configly.drivers.TestsResource2
import dev.techyon.configly.drivers.TestsResource2Servlet
import io.quarkus.arc.deployment.BeanContainerListenerBuildItem
import io.quarkus.deployment.annotations.BuildProducer
import io.quarkus.deployment.annotations.BuildStep
import io.quarkus.deployment.annotations.ExecutionTime
import io.quarkus.deployment.annotations.Record
import io.quarkus.deployment.builditem.FeatureBuildItem
import io.quarkus.undertow.deployment.ServletBuildItem


class GreetingExtensionProcessor {
  @BuildStep
  fun feature(): FeatureBuildItem {
    println("My first build step run")

    return FeatureBuildItem(FEATURE)
  }

  @Record(ExecutionTime.STATIC_INIT)
  @BuildStep
  fun build(
    featureProducer: BuildProducer<FeatureBuildItem?>,
    recorder: AdditionalLogHandlerValueFactory,
    containerListenerProducer: BuildProducer<BeanContainerListenerBuildItem?>,
  ) {
    featureProducer.produce(FeatureBuildItem("liquibase"))
    recorder.create()
    println("EXTENSION WAS TRIGGERED2")
  }

  @BuildStep
  fun createServlet(): ServletBuildItem? {
    return ServletBuildItem.builder(FEATURE, TestsResource2Servlet::class.java.name)
      .addMapping("/greeting")
      .build()
  }

  companion object {
    private const val FEATURE = "config-driver"
  }
}
