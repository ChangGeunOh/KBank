package kr.pe.paran.kbank.common

import io.ktor.http.*

object Constants {

    const val DATABASE_VERSION = 2
    const val DATABASE_NAME = "kbank.db"
    const val DATASTORE_NAME = "kbank.store"

    // http://121.190.44.10:7070/api/v1/geniestore/
    val REMOTE_SERVER_PROTOCOL = URLProtocol.HTTP
    const val REMOTE_SERVER_HOST = "121.165.130.164"
    const val REMOTE_SERVER_PORT = 7070

    const val URL_AUTH = "/auth/login"
    const val URL_ACCESS_TOKEN = "/auth/token"

    val JOB_ID_RANGE = 0xfedcb0..0xfedcbf
    const val JOB_ID_LAZY_LOADING = 0xfedcba
    const val JOB_ID_APP_UPDATE = 0xfedcbb

}