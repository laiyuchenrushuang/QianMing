package daodemo.hc.com.test_demo.handwritten;

import java.nio.ByteBuffer;

public class Xscx {
	 private static ByteBuffer buffer = ByteBuffer.allocate(8);
	public Xscx() {
		byte a = 10;
		byte[] b = new byte[16];
		short data = 1;
		int datas=1;
		getUnsignedByte(a);
		getUnsignedByte(data);
		getUnsignedIntt(datas);
		
	}

	public int getUnsignedByte(byte data) {
		// 将data字节型数据转换为0~255 (0xFF 即BYTE)�?
		return data & 0x0FF;
	}

	public int getUnsignedByte(short data) { 
		// 将data字节型数据转换为0~65535 (0xFFFF �?
												// WORD)�?
		return data & 0x0FFFF;
	}

	public long getUnsignedIntt(int data) { 
		// 将int数据转换�?0~4294967295
											// (0xFFFFFFFF即DWORD)�?
		return data & 0x0FFFFFFFFl;
	}
	//byte �? int 的相互转�?  
    public static byte intToByte(int x) {  
        return (byte) x;  
    }  
      
    public static int byteToInt(byte b) {  
        //Java 总是�? byte 当做有符处理；我们可以�?�过将其�? 0xFF 进行二进制与得到它的无符�?  
        return b & 0xFF;  
    }  
      
    //byte 数组�? int 的相互转�?  
    public static int byteArrayToInt(byte[] b) {  
        return   b[3] & 0xFF |  
                (b[2] & 0xFF) << 8 |  
                (b[1] & 0xFF) << 16 |  
                (b[0] & 0xFF) << 24;  
    }  
  
    public static byte[] intToByteArray(int a) {  
        return new byte[] {  
            (byte) ((a >> 24) & 0xFF),  
            (byte) ((a >> 16) & 0xFF),     
            (byte) ((a >> 8) & 0xFF),     
            (byte) (a & 0xFF)  
        };  
    }  
  
    //byte 数组�? long 的相互转�?  
    public static byte[] longToBytes(long x) {  
        buffer.putLong(0, x);  
        return buffer.array();  
    }  
  
    public static long bytesToLong(byte[] bytes) {  
        buffer.put(bytes, 0, bytes.length);  
        buffer.flip();//need flip   
        return buffer.getLong();  
    }  
	// 将long型数据转换为Dword的字节数组（C/C++的无符号整数�?
	private static byte[] longToDword(long value) {

		byte[] data = new byte[4];

		for (int i = 0; i < data.length; i++) {
			data[i] = (byte) (value >> (8 * i));
		}

		return data;
	}

	/**
	 * @功能: BCD码转�?10进制�?(阿拉伯数�?)
	 * @参数: BCD�?
	 * @结果: 10进制�?
	 */
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
	}

	/**
	 * @功能: 10进制串转为BCD�?
	 * @参数: 10进制�?
	 * @结果: BCD�?
	 */
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}
	public static byte[] strs2Bcd(String asc) {
	    int len = asc.length();
	    int mod = len % 2;

	    if (mod != 0) {
	     asc = "0" + asc;
	     len = asc.length();
	    }

	    byte abt[] = new byte[len];
	    if (len >= 2) {
	     len = len / 2;
	    }
	    byte bbt[] = new byte[len];
	    abt = asc.getBytes();
	    int j, k;

	    for (int p = 0; p < asc.length()/2; p++) {
	     if ( (abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
	      j = abt[2 * p] - '0';
	     } else if ( (abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
	      j = abt[2 * p] - 'a' + 0x0a;
	     } else {
	      j = abt[2 * p] - 'A' + 0x0a;
	     }

	     if ( (abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
	      k = abt[2 * p + 1] - '0';
	     } else if ( (abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
	      k = abt[2 * p + 1] - 'a' + 0x0a;
	     }else {
	      k = abt[2 * p + 1] - 'A' + 0x0a;
	     }

	     int a = (j << 4) + k;
	     byte b = (byte) a;
	     bbt[p] = b;
	    }
	    return bbt;
	}
}
