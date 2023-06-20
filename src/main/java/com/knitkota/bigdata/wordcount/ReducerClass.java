package com.knitkota.bigdata.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerClass extends Reducer<Text, LongWritable, Text, LongWritable> {

	@Override
	protected void reduce(Text key, Iterable<LongWritable> value,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {

		try {

			long totalValues = 0;

			for (LongWritable v : value) {
				totalValues += v.get();
			}

			if (totalValues >= 100) {
				context.write(key, new LongWritable(totalValues));
			}

		} catch (Exception e) {

		}

	}

}
