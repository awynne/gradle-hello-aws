import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.AmazonS3Client

AmazonS3 s3 = new AmazonS3Client()
List<Bucket> buckets = s3.listBuckets()

buckets.each {
	println "buck: ${it}"
}



