package game;

import java.io.*;

public class Landlist {
    
    public Landlist(){
	
	
	PrintWriter output = null;
    
	try{
	
	    output = new PrintWriter(new FileOutputStream("landlist.txt"));
    
	} catch(FileNotFoundException e) {
	    System.out.println(".........");
	}
    
	output.print(
		"83\n"
		+"3 資工系館 2250 1375 100 100 0\n"
		+"1 博理館 2375 1375 100 100 11000\n"
		+"2 法律學研究所 2500 1125 100 100 52000\n"
		+"1 霖澤館 2500 1000 100 100 13000\n"
		+"3 社科院工地 2250 750 225 100 0\n"
		+"1 語言中心 2125 750 100 100 8500\n"
		+"1 視聽館 2000 750 100 100 9000\n"
		+"3 計中 1875 750 100 100 0\n"   
		+"1 女八舍 1750 1000 100 100 10500\n"
		+"1 數學系館 1625 1000 100 100 9500\n"
		+"1 思亮館 1625 625 100 100 8800\n"
		+"1 天文數學館 1500 625 100 100 12000\n"
		+"1 醉月湖 1375 875 100 100 10600\n" 
		+"2 物理學研究所 1250 625 100 100 51500\n"
		+"1 全球變遷中心 1125 625 100 100 8900\n" 
		+"3 綜合體育館 1000 625 100 100 0\n"
		+"3 運動場 875 875 100 350 0\n"
		+"3 普通教室 1000 1375 100 100 0\n"
		+"3 小福 1125 1375 100 100 0\n"
		+"3 郵局 1250 1125 100 100 0\n" 
		+"1 化學系館 1375 1125 100 100 9700\n"
		+"1 化工系館 1625 1250 100 100 7700\n"
		+"2 土木工程學研究所 1625 1375 100 100 48500\n"
		+"1 文學院 1375 1500 100 100 12300\n"
		+"1 四號館 1625 1625 100 100 8600\n"
		+"1 五號館 1625 1700 100 100 9000\n"
		+"3 行政大樓 1250 1875 100 100 0\n"
		+"3 校長室 1125 1875 100 100 0\n"
		+"1 三號館 1000 1875 100 100 9600\n"
		+"1 二號館 875 1625 100 100 8300\n"
		+"1 一號館 750 1625 100 100 8600\n"
		+"1 植微標本館 625 1875 100 100 9400\n"
		+"1 女一舍 625 2000 100 100 10100\n"
		+"1 女三舍 625 2125 100 100 10600\n"
		+"1 女五舍 875 2250 100 100 10800\n"
		+"1 女二舍 625 2375 100 100 11600\n"
		+"1 大一女舍 625 2500 100 100 14500\n"
		+"3 ATM 875 2625 100 100 0\n"
		+"1 研一舍 1000 2375 100 100 11300\n"
		+"1 地質科學系館 1250 2500 100 100 8900\n"
		+"3 駐衛警察隊 1250 2625 100 100 0\n"
		+"1 銘傳國小 1000 2875 100 100 13600\n"
		+"1 台大附設幼稚園 1000 3000 100 100 7000\n"
		+"3 二活 1250 3125 100 100 0\n"
		+"2 財務金融學研究所 1375 3125 100 100 46700\n"
		+"1 大氣系 1625 3000 100 100 8400\n"
		+"1 地質環境資源學系 1625 2875 100 100 10900\n"
		+"1 鹿鳴雅舍 1375 2700 100 100 9900\n"
		+"1 鹿鳴堂 1375 2625 100 100 12400\n"
		+"3 小小福 1375 2500 100 100 0\n"
		+"3 共同教室 1375 2375 100 100 0\n"
		+"1 生命科學館 1750 2375 100 100 16800\n"
		+"1 生態池 1750 2250 100 100 8000\n"
		+"1 森林系 1500 2125 100 100 9800\n"
		+"3 衛生保健及醫療中心 1625 1875 100 100 0\n"
		+"3 總圖 1875 1875 100 100 0\n"
		+"1 工科海洋系館 2000 2125 100 100 13500\n"
		+"1 環境工程系館 2125 2125 100 100 12100\n"
		+"1 生機電系館 2250 1875 100 100 7900\n"
		+"1 明達館 2500 2000 100 100 15000\n"
		+"3 ATM 2500 2125 100 100 0\n"
		+"3 男一舍 2250 2250 100 100 0\n"
		+"1 男五舍 2500 2500 100 100 13300\n"
		+"1 男三舍 2625 2500 100 100 13000\n"
		+"1 男七舍 2750 2500 100 100 11500\n"
		+"1 男六舍 2875 2250 100 100 11000\n"
		+"1 男八舍 2625 2125 100 100 7100\n"
		+"1 BOT 2875 2000 100 100 12400\n"
		+"3 地震球場 2875 1875 100 100 0\n"
		+"1 教職員宿舍(2) 2875 1750 100 100 8600\n"
		+"1 教職員宿舍(1) 2750 1500 100 100 8400\n"
		+"1 電機二館 2625 1500 100 100 7800\n"
		+"1 獸醫學系 2500 1750 100 100 9400\n"
		+"2 材料學研究所 2375 1500 100 100 46900\n"
		+"3 活大 2250 1750 100 100 0\n"
		+"2 機械學研究所 2125 1500 100 100 55000\n"
		+"3 綜合教室 2000 1750 100 100 0\n"
		+"1 電機一館 1750 1625 100 100 9400\n"
		+"2 生化學研究所 1750 1500 100 100 53000\n"
		+"3 新生大樓 1750 1375 100 100 0\n"
		+"1 女九 1875 1125 100 100 11700\n"
		+"2 心理學研究所 2000 1125 100 100 52100\n"
		+"1 社工館 2125 1125 100 100 11900\n"
		//+"1 = building, 2 = lab, 3 = special location"
		);
	output.close();
	
	}
    
    public int getX(int x){
	return (x - 625) / 125;
    }
}
