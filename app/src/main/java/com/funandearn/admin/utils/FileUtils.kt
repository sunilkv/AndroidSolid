package com.funandearn.admin.utils

import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.util.Log
import org.apache.commons.io.IOUtils
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*
import java.util.concurrent.TimeUnit

object FileUtils {
    private val CLEANUP_CUTOFF = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(3)
    private val LOG_FILE_NAME = "agora-rtc.log"
    private val LOG_FOLDER_NAME = "log"
    private val TAG = "TempUtil"
/*
    public static void cleanupStaleFiles(Context context) {
        Collection<File> stale = FileUtils.listFiles(context.getCacheDir(), FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.ageFileFilter(CLEANUP_CUTOFF), FileFilterUtils.m64or(FileFilterUtils.suffixFileFilter(".gif", IOCase.INSENSITIVE), FileFilterUtils.suffixFileFilter(".png", IOCase.INSENSITIVE), FileFilterUtils.suffixFileFilter(".mp4", IOCase.INSENSITIVE))), (IOFileFilter) null);
        if (!stale.isEmpty()) {
            for (File file : stale) {
                FileUtils.deleteQuietly(file);
            }
        }
    }*/

    fun createCopy(context: Context, uri: Uri, suffix: String): File? {
        val os: OutputStream
        val temp = createNewFile(context, suffix)
        try {
            val `is` = context.contentResolver.openInputStream(uri)
            try {
                os = FileOutputStream(temp)
                IOUtils.copy(`is`, os)
                os.close()
                `is`?.close()
            } catch (th: Throwable) {
                `is`?.close()
                throw th
            }
        } catch (e: Exception) {
            Log.e(TAG, "Could not copy $uri")
        } catch (th2: Throwable) {
            //     th.addSuppressed(th2);
        }
        return temp
        // throw th;
    }


    //get the File Size..
    fun getFileSize(fileLength: Long): String? {
        return (fileLength / 1024).toString()
    }


    //get the File Name..
    //get File Duration..
    @Throws(IOException::class)
    fun getFileDuration(uri: Uri?, context: Context?): Long {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(context, uri)
        val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        val timeInMillisec = time!!.toLong()
        retriever.release()
        return timeInMillisec
    }


    fun createNewFile(context: Context, suffix: String): File {
        return createNewFile(context.cacheDir, suffix)
    }

    fun createNewFile(directory: File?, suffix: String): File {
        return File(directory, UUID.randomUUID().toString() + suffix)
    }

    fun createNewFile(directory: String?, suffix: String): File? {
        return File(directory, UUID.randomUUID().toString() + suffix)
    }

    fun initializeLogFile(context: Context): String? {
        val folder: File?
        folder = if (Build.VERSION.SDK_INT >= 29) {
            File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), LOG_FOLDER_NAME)
        } else {
            val folder2 =
                File(Environment.getExternalStorageDirectory().absolutePath + File.separator + context.packageName + File.separator + LOG_FOLDER_NAME)
            if (folder2.exists() || folder2.mkdir()) {
                folder2
            } else {
                null
            }
        }
        return if (folder == null || folder.exists() || folder.mkdir()) {
            File(folder, LOG_FILE_NAME).absolutePath
        } else ""
    }
}