package kr.pe.paran.kbank.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kr.pe.paran.kbank.common.utils.Logcat

class Network {

    private val bearerTokenStorage = mutableListOf<BearerTokens>()

    fun getClient(
        username: String = "",
        password: String = "",
    ): HttpClient {

        return getHttpClient {


            install(Auth) {
                bearer {
                    loadTokens {
                        bearerTokenStorage.last()
                    }
                    refreshTokens {
                        // Access Token 만료시 Refresh Token을 이용하여 Access Token 재발행 후 자동 다시 수행
                        // AccessToken 재 발급시 Refresh Token를 Bearer 인증으로 사용하는 경우 새로운 Client를 생성해야 함.
                        // (Why : Bug 인지 모르겠는데 Client 를 사용하면 Access Token을 강제적으로 주입 함)
                        // 다른 parameter 값으로 Refresh Token 인증하는 경우에는 client 사용하면 됨
                        getHttpClient().use {
                            val tokenData: BearerTokens =
                                it.get(urlString = "http://genietv.iptime.org:3000/auth/token")
                                    .body()
                            bearerTokenStorage.add(
                                BearerTokens(
                                    tokenData.accessToken,
                                    tokenData.refreshToken
                                )
                            )
                            bearerTokenStorage.last()
                        }
                    }
                }
            }
        }
    }

    private fun getHttpClient(
        block: HttpClientConfig<AndroidEngineConfig>.() -> Unit = {},
    ): HttpClient {

        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Logcat.i(message.toString())
                    }
                }
                level = LogLevel.HEADERS
                level = LogLevel.ALL
            }

//            install(DefaultRequest) {
//                url {
//                    protocol = Constants.REMOTE_SERVER_PROTOCOL
//                    host = Constants.REMOTE_SERVER_HOST
//                    port = Constants.REMOTE_SERVER_PORT
//                }
//            }

            install(HttpTimeout) {
                requestTimeoutMillis = 1000
                connectTimeoutMillis = 2000
                socketTimeoutMillis = 2000
            }

            expectSuccess = true
            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, request ->
                    Logcat.i(exception.toString())
                    Logcat.i(request.toString())
//                    val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
//                    val exceptionResponse = clientException.response
//                    if (exceptionResponse.status == HttpStatusCode.NotFound) {
//                        val exceptionResponseText = exceptionResponse.bodyAsText()
//                        Logcat.i("HttpStatusCode.NotFound")
//                    }
                }
            }

            block()
        }
    }

    fun setTokenData(tokenData: BearerTokens) {
        bearerTokenStorage.add(BearerTokens(tokenData.accessToken, tokenData.refreshToken))
    }

}

/*
val client = HttpClient(CIO) {
    expectSuccess = true
    HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, request ->
            val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
            val exceptionResponse = clientException.response
            if (exceptionResponse.status == HttpStatusCode.NotFound) {
                val exceptionResponseText = exceptionResponse.bodyAsText()
                throw MissingPageException(exceptionResponse, exceptionResponseText)
            }
        }
    }
}
 */