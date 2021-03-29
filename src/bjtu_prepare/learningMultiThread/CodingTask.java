package bjtu_prepare.learningMultiThread;

/**
 * @Title
 * @Description
 * @Author SuperBin
 * @Date 2020年9月1日
 */
public class CodingTask implements Runnable {

    private final int employeeId;

    public CodingTask(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Employee " + employeeId + " start doing Work!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
//			e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Employee " + employeeId + " has finished work!");
    }


}
