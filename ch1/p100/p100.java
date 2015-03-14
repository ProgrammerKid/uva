import java.io.*;
class p100 {
	
	static int n;
	static int cycleLen = 0;
	static int tmpCycleLen = 0;
	static String opts[] = new String[2];

	static void loop() {
		if(n == 1) {
			tmpCycleLen++;
			if(tmpCycleLen > cycleLen)
				cycleLen = tmpCycleLen;
			return;
		}

		if(n % 2 == 1)
			n = 3*n + 1;
		else
			n = n / 2;
		
		tmpCycleLen++;

		loop();
	}

	public static void main(String args[]) throws java.lang.Exception {
		BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		
		opts = input.readLine().split(" ");
		int min = Integer.parseInt(opts[0]);
		int max = Integer.parseInt(opts[1]);
		for(int i = min; i <= max; i++) {
			tmpCycleLen = 0;
			n = i;
			loop();
		}
		System.out.printf("%d %d %d\n", min, max, cycleLen);
		System.exit(0);
	}
}
