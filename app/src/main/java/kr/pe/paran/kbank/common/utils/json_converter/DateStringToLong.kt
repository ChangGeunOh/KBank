package kr.pe.paran.kbank.common.utils.json_converter

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.SimpleDateFormat
import java.util.*

object DateStringToLong : KSerializer<Long> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Long {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
        val value = decoder.decodeString().replace("T", " ")
        val date = simpleDateFormat.parse(value)
        return date?.time ?: 0L
    }

    override fun serialize(encoder: Encoder, value: Long) =
        encoder.encodeString(SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(value))

}