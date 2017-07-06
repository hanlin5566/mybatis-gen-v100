package util;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;

public class ImageMain {

	public static void main(String[] args) throws JpegProcessingException, IOException, MetadataException {
		File jpegFile = new File("/Desktop/research/AFE554867F7172344AECCEA8699A72B2.jpeg");

		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);

		Iterator<Directory> dirs = metadata.getDirectories().iterator();
		while (dirs.hasNext()) {
			Directory directory = dirs.next();
			System.out.println("* directory> " + directory);

			if (directory.containsTag(ExifDirectoryBase.TAG_ORIENTATION)) {
				int orientation = directory.getInt(ExifDirectoryBase.TAG_ORIENTATION);
				System.out.println("* orientation> " + orientation);
			}

			Collection<Tag> tags = directory.getTags();
			Iterator<Tag> tagsIter = tags.iterator();
			while (tagsIter.hasNext()) {
				Tag tag = tagsIter.next();
				System.out.println(tag);
			}
		}

	}

}
