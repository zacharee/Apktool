package tk.zwander.android.streamdecoders

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import brut.androlib.AndrolibException
import brut.androlib.res.decoder.Res9patchStreamDecoder
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class AndroidRed9PatchStreamDecoder : Res9patchStreamDecoder() {
    override fun decode(`in`: InputStream, out: OutputStream) {
        try {
            val data = `in`.readBytes()

            if (data.isEmpty()) {
                return
            }

            val image = BitmapFactory.decodeByteArray(data, 0, data.size)

            image.compress(Bitmap.CompressFormat.PNG, 100, out)
        } catch (e: IOException) {
            throw AndrolibException(e)
        } catch (e: NullPointerException) {
            throw AndrolibException(e)
        }
    }
}