package finatra.quickstart

import com.twitter.finagle.http.{Response, Request}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.logging.filter.LoggingMDCFilter
import com.twitter.finatra.logging.modules.LogbackModule
import finatra.quickstart.controllers.TweetsController
import finatra.quickstart.domain.StatusMessageBodyWriter
import finatra.quickstart.firebase.FirebaseHttpClientModule
import finatra.quickstart.warmup.TwitterCloneWarmup

class TwitterCloneServer extends HttpServer {
  override val modules = Seq(FirebaseHttpClientModule, LogbackModule)

  override def configureHttp(router: HttpRouter): Unit = {
    router
      .register[StatusMessageBodyWriter]
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[TweetsController]
  }

  override def warmup() {
    run[TwitterCloneWarmup]()
  }
}
