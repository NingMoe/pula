using System;
using System.Collections.Generic;
using System.Text;

namespace PulaRfid
{
    /**
     * ͷ����Ϣ
     * 
     * */
    public class CardMeta
    {

        public string no { get; set; }
        public string name { get; set; }

        public int type { get; set; }

    }


    public class BlockData
    {
        private byte[] bytes = null;

        public byte[] Bytes
        {
            get { return bytes; }
            set { bytes = value; }
        }
        //private byte block;

        public static BlockData MergeInt(int n1, int n2, int n3, int n4)
        {
            byte[] ret = new byte[16];
            int i = 0;
            byte[] bs = System.BitConverter.GetBytes(n1);

            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            bs = System.BitConverter.GetBytes(n2);
            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            bs = System.BitConverter.GetBytes(n3);
            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            bs = System.BitConverter.GetBytes(n4);
            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];

            BlockData bd = new BlockData();
            bd.bytes = ret;
            return bd;
        }


        public static BlockData MergeLong(long n1, int n3, int n4)
        {
            byte[] ret = new byte[16];
            int i = 0;
            byte[] bs = System.BitConverter.GetBytes(n1);

            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            ret[i++] = bs[4];
            ret[i++] = bs[5];
            ret[i++] = bs[6];
            ret[i++] = bs[7];
            bs = System.BitConverter.GetBytes(n3);
            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            bs = System.BitConverter.GetBytes(n4);
            ret[i++] = bs[0];
            ret[i++] = bs[1];
            ret[i++] = bs[2];
            ret[i++] = bs[3];
            BlockData bd = new BlockData();
            bd.bytes = ret;
            return bd;
        }

        public static BlockData BuildFromBytes(byte[] bs, byte size)
        {

            BlockData bd = new BlockData();
            bd.bytes = new byte[size];
            Array.Copy(bs, 0, bd.bytes, 0, size);
            return bd;
        }

        public void Modify(int pos, short n)
        {
            byte[] bs = System.BitConverter.GetBytes(n);

            for (int i = 0; i < bs.Length; i++)
            {
                this.bytes[pos + i] = bs[i];

            }

        }

        public int[] AsInts()
        {

            List<int> ret = new List<int>();
            //ȡ�ĸ��ֽ�����һ��int
            int size = this.bytes.Length;
            int p = 0;
            byte[] intb = new byte[4];
            while ((p + 4) <= size)
            {
                Array.Copy(this.bytes, p, intb, 0, 4);

                ret.Add(System.BitConverter.ToInt32(intb, 0));

                p += 4;
            }


            return ret.ToArray();
        }

        public string AsString(int start, int end)
        {
            int len = end - start ;
            byte[] ret = new byte[len];
            Array.Copy(this.bytes, start, ret, 0, len);

            return Encoding.UTF8.GetString(ret);
        }

        public int AsInteger(int start)
        {
            int len = 4;
            byte[] ret = new byte[len];
            Array.Copy(this.bytes, start, ret, 0, len);

            return System.BitConverter.ToInt32(ret, 0);
        }

        public short[] AsShorts()
        {
            List<short> ret = new List<short>();
            //ȡ�ĸ��ֽ�����һ��int
            int size = this.bytes.Length;
            int p = 0;
            byte[] intb = new byte[2];
            while ((p + 2) <= size)
            {
                Array.Copy(this.bytes, p, intb, 0, 2);

                ret.Add(System.BitConverter.ToInt16(intb, 0));

                p += 4;
            }


            return ret.ToArray();

        }


        public byte[] GetPosition(int pos)
        {
            return new byte[] { this.bytes[pos], this.bytes[pos + 1] };
        }

        public List<BlockData> PrepareBlockData(List<byte> list, ref byte lastPos, bool needThis)
        {
            List<BlockData> ret = new List<BlockData>();

            int pos = lastPos + 1;
            int wrotenCount = 0;

            //�������Ҫ��ǰ��������Ϊ����

            if (needThis)
            {
                int spaces = 15 - lastPos;

                //ֻȡҪ�Ĳ���

                while (spaces > 0 && list.Count > wrotenCount)
                {
                    this.bytes[pos + wrotenCount] = list[wrotenCount];
                    wrotenCount++;
                    spaces--;
                }
                ret.Add(this);

            }

            //����������byte��Ҫ���µ�bd��

            BlockData bd = null;
            pos = 0;



            while (list.Count > wrotenCount)
            {
                //�����ǵ�һ����ʱ��
                if (pos == 0)
                {
                    //�������ݲ��ǿյģ�����
                    if (bd != null)
                    {
                        ret.Add(bd);
                    }

                    //�����µ�
                    bd = new BlockData();
                    bd.bytes = new byte[16];

                }

                //���ɡ���
                bd.bytes[pos] = list[wrotenCount++];
                lastPos = (byte)pos;

                pos++;

                if (pos == 16)
                {
                    pos = 0;
                }


            }

            //�����������Ҳ�ŵ��б���
            if (bd != null)
            {
                ret.Add(bd);
            }

            return ret;
        }
        /*
        internal List<BlockData> MakeList(List<byte> list, ref byte lastPos)
        {
            List<BlockData> ret = new List<BlockData>();
            BlockData bd = null;
            int pos = 0;
            int i = 0;
            while (list.Count > i)
            {
                //�����ǵ�һ����ʱ��
                if (pos == 0)
                {
                    //�������ݲ��ǿյģ�����
                    if (bd != null)
                    {
                        ret.Add(bd);
                    }

                    //�����µ�
                    bd = new BlockData();
                    bd.bytes = new byte[16];

                }

                //���ɡ���
                bd.bytes[pos] = list[i++];
                lastPos = (byte)pos;
                pos++;
                if (pos == 16)
                {
                    pos = 0;
                }


            }

            //�����������Ҳ�ŵ��б���
            if (bd != null)
            {
                ret.Add(bd);
            }

            return ret;
        }*/

        public void SetPosition(int p, byte lastBlock, byte lastPos)
        {
            this.bytes[p] = lastBlock;
            this.bytes[p + 1] = lastPos;
        }

        public short GetShort(int p)
        {
            byte[] bs = new byte[2];

            bs[0] = this.Bytes[p];
            bs[1] = this.Bytes[p + 1];
            return System.BitConverter.ToInt16(bs, 0);
        }

        public static BlockData CreateEmpty()
        {
            BlockData bd = new BlockData();
            bd.Bytes = new byte[16];
            return bd;
        }

        public int GetInt(int p)
        {
            return ByteReader.GetInt(this.bytes, p);
        }

        public long GetLong(int p)
        {
            return ByteReader.GetLong(this.bytes, p);
        }

       /* public static BlockData MergeGoods(Goods n1, Goods n2, Goods n3, Goods n4)
        {
            byte[] ret = new byte[16];
            int i = 0;
            byte[] bs = null;
            if (n1 != null)
            {
                bs = System.BitConverter.GetBytes(n1.Id);
                ret[i++] = bs[0];
                ret[i++] = bs[1];
                bs = System.BitConverter.GetBytes(n1.Type);
                ret[i++] = bs[0];
                ret[i++] = bs[1];

            }
            else
            {

                i += 4;

            }

            if (n2 != null)
            {
                bs = System.BitConverter.GetBytes(n2.Id);
                ret[i++] = bs[0];
                ret[i++] = bs[1];
                bs = System.BitConverter.GetBytes(n2.Type);
                ret[i++] = bs[0];
                ret[i++] = bs[1];

            }
            else
            {
                i += 4;
            }

            if (n3 != null)
            {
                bs = System.BitConverter.GetBytes(n3.Id);
                ret[i++] = bs[0];
                ret[i++] = bs[1];
                bs = System.BitConverter.GetBytes(n3.Type);
                ret[i++] = bs[0];
                ret[i++] = bs[1];

            }
            else
            {
                i += 4;
            }

            if (n4 != null)
            {
                bs = System.BitConverter.GetBytes(n4.Id);
                ret[i++] = bs[0];
                ret[i++] = bs[1];
                bs = System.BitConverter.GetBytes(n4.Type);
                ret[i++] = bs[0];
                ret[i++] = bs[1];
            }
            else
            {
                i += 4;
            }

            BlockData bd = new BlockData();
            bd.bytes = ret;
            return bd;
        }

        public Goods[] AsGoodss()
        {
            List<Goods> ret = new List<Goods>();
            //ȡ�ĸ��ֽ�����һ��int
            int size = this.bytes.Length;
            int p = 0;
            byte[] intb = new byte[2];
            while ((p + 4) <= size)
            {
                Array.Copy(this.bytes, p, intb, 0, 2);
                ushort id = System.BitConverter.ToUInt16(intb, 0);
                Array.Copy(this.bytes, p+2, intb, 0, 2);
                short type = System.BitConverter.ToInt16(intb, 0);


                Goods g = new Goods(id,type);

                ret.Add(g);

                p += 4;
            }


            return ret.ToArray();
        }*/

        internal void WriteInt(int p)
        {
            byte[] bs = System.BitConverter.GetBytes(p);
            Array.Copy(bs, 0, this.bytes, 12, 4);

        }

        public void WriteBytes(byte[] bs, byte size)
        {
            if (bs.Length < size)
            {
                size = (byte) bs.Length;
            }
            
            Array.Copy(bs, 0, bytes, 0, size);
            
        }
    }

    public class BlockException : Exception
    {

        private int absblock;

        private int section, block;

        public int Block
        {
            get { return block; }
            set { block = value; }
        }

        public int Section
        {
            get { return section; }
            set { section = value; }
        }

        public int Absblock
        {
            get { return absblock; }
            set { absblock = value; }
        }

        public BlockException(int block, string exception)
            : base(exception)
        {

            this.absblock = block;
            makeSectionAndBlock();
        }

        private void makeSectionAndBlock()
        {
            SectionTool.getSectionAndBlock(this.block, ref this.section, ref this.block);
        }
    }

    public class SectionTool
    {

        public static void getSectionAndBlock(int absblock, ref int s1, ref int b1)
        {
            int split = 32 * 4;
            if (absblock > split)
            {
                int left = absblock - split;
                int s = left / 16;
                int b = left % 16;
                s1 = s + 32;
                b1 = b;
            }
            else
            {
                int s = absblock / 4;
                int b = absblock % 4;
                s1 = s;
                b1 = b;
            }
        }

    }
}
