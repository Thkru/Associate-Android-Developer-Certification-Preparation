package com.thkrue.cert;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class MyJobService extends JobService {

    public static void scheduleJob(Context context) {

        JobInfo.Builder builder = new JobInfo.Builder(0, new ComponentName(context, MyJobService.class));
//        builder.setMinimumLatency(5 * 1000); // wait at least
        builder.setOverrideDeadline(30 * 1000); // maximum delay
//        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
//        builder.setRequiresDeviceIdle(true); // device should be idle
//        builder.setRequiresCharging(false); // we don't care if the device is charging or not
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();

        new AsyncTask<Context, String, Context>() {

            @Override
            protected Context doInBackground(Context... c) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                }

                return c[0];
            }

            @Override
            protected void onPostExecute(Context c) {
                super.onPostExecute(c);
                Toast.makeText(c, "End", Toast.LENGTH_SHORT).show();
            }
        }.execute(getApplicationContext());

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
