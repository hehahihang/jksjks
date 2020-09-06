/*
[���ؾ˰���][N7569][�丶��]
ö���� �丶�� ���忡���� �丶�並 �����ϴ� ū â�� ������ �ִ�. �丶��� �Ʒ��� �׸��� ���� ���ڸ�� ������ ĭ�� �ϳ��� ���� ����, ���ڵ��� �������� �׾� �÷��� â�� �����Ѵ�.
â�� �����Ǵ� �丶��� �߿��� �� ���� �͵� ������, ���� ���� ���� �丶��鵵 ���� �� �ִ�. ���� �� �Ϸ簡 ������, ���� �丶����� ������ ���� �ִ� ���� ���� �丶����� ���� �丶���� ������ �޾� �Ͱ� �ȴ�. 
�ϳ��� �丶�信 ������ ���� ��, �Ʒ�, ����, ������, ��, �� ���� ���⿡ �ִ� �丶�並 �ǹ��Ѵ�. 
�밢�� ���⿡ �ִ� �丶��鿡�Դ� ������ ���� ���ϸ�, �丶�䰡 ȥ�� ������ �ʹ� ���� ���ٰ� �����Ѵ�. ö���� â�� ������ �丶����� ��ĥ�� ������ �� �Ͱ� �Ǵ��� �� �ּ� �ϼ��� �˰� �;� �Ѵ�.
�丶�並 â�� �����ϴ� ���ڸ���� ���ڵ��� ũ��� ���� �丶���� ���� ���� �丶����� ������ �־����� ��, 
��ĥ�� ������ �丶����� ��� �ʹ���, �� �ּ� �ϼ��� ���ϴ� ���α׷��� �ۼ��϶�. ��, ������ �Ϻ� ĭ���� �丶�䰡 ������� ���� ���� �ִ�.

�Է�
ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �׾ƿ÷����� ������ ���� ��Ÿ���� H�� �־�����. M�� ������ ���� ĭ�� ��, N�� ������ ���� ĭ�� ���� ��Ÿ����. 
��, 2 �� M �� 100, 2 �� N �� 100, 1 �� H �� 100 �̴�. ��° �ٺ��ʹ� ���� ���� ���ں��� ���� ���� ���ڱ����� ����� �丶����� ������ �־�����. ��, ��° �ٺ��� N���� �ٿ��� �ϳ��� ���ڿ� ��� �丶���� ������ �־�����.
�� �ٿ��� ���� �����ٿ� ����ִ� �丶����� ���°� M���� ������ �־�����. ���� 1�� ���� �丶��, ���� 0 �� ���� ���� �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����. �̷��� N���� ���� H�� �ݺ��Ͽ� �־�����.

���
�������� �丶�䰡 ��� ���� ������ �ּ� ��ĥ�� �ɸ������� ����ؼ� ����ؾ� �Ѵ�. ����, ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1�� ����ؾ� �Ѵ�.*/

/*
[���� ����]
 ������ Ǯ���� BFS������ �ٸ��ٰ� ���� Github�� �� ���ε� �ϰ�;���.
 ���� �������� ���ǿ� �´� 2���� �迭�� ���Ҹ� �����ؼ� �ű⿡�� bfs�� ��� �����ϰ� �ٽ� main���� ���ƿͼ� �ٽ� ������ Ž���ϴ� ��찡 ���Ҵ�.
 ������ �� ������ ���ǿ� �´� 3���� �迭�� ���ҵ��� ��� Queue�� �ѹ��� �� ����ְ� �� ���Ŀ� �� Queue�� ���ؼ� bfs�� �����Ѵٴ� �� ������ ������ �򰥷ȴ�.
 ģ��ģ���� ��α׸� ���� �����ؼ� Ǯ���٤Ф� ���� �ؼ����� Ű������ �ʿ䰡 �ְڴٴ� ������ �����!*/

package BFS;

//�丶���� ����
//1 : ���� �丶��
//0 : ���� ���� �丶��
//-1 : �丶�䰡 ���� �ڸ�

import java.io.*;
import java.util.*;

public class N7569 {
	static int m,n,h;
	static int [][][] arr;
	static boolean [][][] visited;
	static int [] dx = {1,-1,0,0,0,0}; 
	static int [] dy = {0,0,1,-1,0,0}; 
	static int [] dz = {0,0,0,0,1,-1};
	static boolean flag = true;
	static int cnt = 0;
	static Queue<tmt> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //������ ����ĭ ��
		n = Integer.parseInt(st.nextToken()); //������ ����ĭ ��
		h = Integer.parseInt(st.nextToken()); //������ ��
		arr = new int [n][m][h];
		visited = new boolean [n][m][h];
		
		for(int i=0;i<h;i++) {//��
			for(int j=0;j<n;j++) {//��
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {//��
					arr[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int i=0;i<h;i++) {//��
			for(int j=0;j<n;j++) {//��
				for(int k=0;k<m;k++) {//��
					if(arr[j][k][i]==1) {
						//1�� ����ִ� ���� ��� Queue�� �־���� �ϳ��� �����鼭 bfs�� �����Ѵ�.
						queue.add(new tmt(j,k,i));
					}
				}
			}
		}
		
		//�� ���� �������� queue���� ���� 1 ��,��,��,��,��,���� �丶�並 ��� �Ͱ��Ѵ�.
		while(true) {
			bfs(queue);
			if(!flag) {
				break;
			}
			cnt++;
			//�׸��� while���� �����Ҷ����� 1�������Ѵ�.
		}
		check();
		
	}
	
	public static void bfs(Queue<tmt> queue) {
		int size = queue.size();
		
		for(int i=0;i<size;i++) {
			tmt t = queue.poll();
			for(int j=0;j<6;j++) {
				int nx = t.x + dx[j];
				int ny = t.y + dy[j];
				int nz = t.z + dz[j];
				
				//������ �����ϴ� ���� �ִٸ� 1�� ���� == ���� �丶��� ������ �־ ���� ���ɼ��� �ִ� �丶�並 �Ͱ� ���ش�.
				if(nx>=0 && ny>=0 && nz>=0 && nx<n && ny<m && nz<h) {
					if(arr[nx][ny][nz]==0) {
						arr[nx][ny][nz] = 1;
						queue.add(new tmt(nx,ny,nz));
					}
				}
			}
		}
		
		if(queue.size()==0) {
			flag = false;
			return;
		}
	}
	
	public static void check() {
		for(int i=0;i<h;i++) {//��
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					//���� ���� �丶�䰡 �ϳ��� �ִٸ� -1���
					if(arr[j][k][i]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		//�ƴ϶�� cnt���
		System.out.println(cnt);
	}
	
}

class tmt{
	int x,y,z;
	public tmt(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}