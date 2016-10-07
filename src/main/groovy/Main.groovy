import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.AmazonS3Client
import java.util.concurrent.*
import org.apache.commons.cli.*

AmazonS3 s3 = new AmazonS3Client()
List<Bucket> buckets = s3.listBuckets()

def meth = System.getProperty("method")
if(meth) {
    println("running: ${meth}")
    def run = {bucket -> println "buck: ${bucket}"}
    def pool = Executors.newFixedThreadPool(4)

    List<Future> futures = buckets.collect { bucket ->
        pool.submit({-> run bucket } as Callable);
    }
    
    futures.each{it.get()}
    pool.shutdown()
}
else {
    print "whoops"
}


