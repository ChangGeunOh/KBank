package kr.pe.paran.kbank.common.utils.json_converter

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StringToBoolean : KSerializer<Boolean> {

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("hasAds", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Boolean {
        val value = decoder.decodeString()
//        Logcat.i("SERIAL>${decoder.decodeString()}")
//        val result = decoder.decodeString()
//            .contains(other = "Y", ignoreCase = true) || decoder.decodeString()
//            .contains(other = "YES", ignoreCase = true)
//        Logcat.i("SERIAL>${decoder.decodeString()} :: $result")
        return value.contains("N", ignoreCase = true)
    }

    override fun serialize(encoder: Encoder, value: Boolean) =
        encoder.encodeString(if (value) "Y" else "N")
}