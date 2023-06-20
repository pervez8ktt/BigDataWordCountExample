package com.knitkota.bigdata.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

	public static void main(String[] args) {
		try {

			Configuration conf = new Configuration();
			// conf.set("name", "value")
			// conf.set("mapreduce.input.fileinputformat.split.minsize", "134217728");
			Job job = Job.getInstance(conf, "Assigenment One");
			job.setJarByClass(WordCount.class);
			job.setMapperClass(MapperClass.class);
			// job.setCombinerClass(ReduceClass.class);
			job.setReducerClass(ReducerClass.class);
//			job.setNumReduceTasks(1);

			job.setNumReduceTasks(2);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(LongWritable.class);

			FileInputFormat.addInputPath(job, new Path(args[0]));

			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			System.exit(job.waitForCompletion(true) ? 0 : 1);

		} catch (Exception e) {

		}

	}

}
