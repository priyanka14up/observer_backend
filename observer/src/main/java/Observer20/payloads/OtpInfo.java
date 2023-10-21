package Observer20.payloads;

public class OtpInfo {
   
    private final long timestamp;
    private int requestCount;

    public OtpInfo(long timestamp, int requestCount) {
       // this.otp = otp;
        this.timestamp = timestamp;
        this.requestCount = requestCount;
    }

  
    public long getTimestamp() {
        return timestamp;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public boolean isBlocked() {
        // Check if the user has exceeded the OTP limit within 30 minutes
        int otpLimit = 3;
        long timeLimit = 30 * 60 * 1000; // 30 minutes in milliseconds
        long currentTime = System.currentTimeMillis();
        
        // Check if the request count is within the limit and within the time limit
        return requestCount >= otpLimit && currentTime - timestamp < timeLimit;
    }
}
