package com.howtographql.scala.sangria

import com.howtographql.scala.sangria.models.Authorized
import sangria.execution.{Middleware, MiddlewareBeforeField, MiddlewareQueryContext}
import sangria.schema.Context

object AuthMiddleware extends Middleware[MyContext] with MiddlewareBeforeField[MyContext] {
  override type QueryVal = Unit
  override type FieldVal = Unit

  override def beforeQuery(contetext: MiddlewareQueryContext[MyContext, _, _]) = ()

  override def afterQuery(queryVal: QueryVal, context: MiddlewareQueryContext[MyContext, _, _]) = ()

  override def beforeField(queryVal: QueryVal, mctx: MiddlewareQueryContext[MyContext, _, _], ctx: Context[MyContext, _]) = {
    val requreAuth = ctx.field.tags contains Authorized

    if(requreAuth) ctx.ctx.ensureAuthenticated()

    continue
  }
}
