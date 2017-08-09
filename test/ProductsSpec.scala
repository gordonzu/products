package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ProductsSpec extends Specification {
  
  "Products" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/product")) must beNone        
      }
    }
    
    "render the products page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/products")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Product Catalog")
      }
    }
  }
}


