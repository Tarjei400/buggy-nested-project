package dev.techyon.configly.drivers

import io.quarkus.test.QuarkusUnitTest
import io.restassured.RestAssured
import org.hamcrest.Matchers
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.spec.JavaArchive
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.wildfly.common.net.CidrAddress
import java.util.function.Supplier


open class GreetingResourceTest2 {

  companion object {

    @RegisterExtension
    val config = QuarkusUnitTest()
      .withEmptyApplication()
  }

  @Test
  open fun testGreeting() {
    RestAssured.`when`().get("/greeting").then().statusCode(200).body(
      Matchers.containsString("Hello")
    )
  }

  @Test
  open fun testVersionInPackage() {
    Assertions.assertNotNull(CidrAddress::class.java.getPackage().implementationVersion)
  }

  @Test
  open fun testAssumptionsWork() {
    //these were broken at one point
    Assumptions.assumeTrue(false)
  }
}