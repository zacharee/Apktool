package tk.zwander.android

import android.content.Context
import brut.androlib.res.AndrolibResources
import brut.androlib.res.decoder.*
import brut.util.Duo
import tk.zwander.android.streamdecoders.AndroidRed9PatchStreamDecoder
import java.io.File


class AndrolibResourcesAndroid(private val context: Context) : AndrolibResources() {
    override fun getResFileDecoder(): Duo<ResFileDecoder, AXmlResourceParser> {
        val decoders = ResStreamDecoderContainer()
        decoders.setDecoder("raw", ResRawStreamDecoder())
        decoders.setDecoder("9patch", AndroidRed9PatchStreamDecoder())

        val axmlParser = AXmlResourceParser()
        axmlParser.attrDecoder = ResAttrDecoder()
        decoders.setDecoder("xml", XmlPullStreamDecoder(axmlParser, resXmlSerializer))

        return Duo(ResFileDecoder(decoders), axmlParser)
    }

    override fun createAndroidFrameworkPath(): String {
        return File(context.cacheDir, "apktool-frameworks").absolutePath
    }
}