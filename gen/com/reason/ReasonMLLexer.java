/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.reason;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import static com.reason.lang.ReasonMLTypes.*;
import static com.intellij.psi.TokenType.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>ReasonML.flex</tt>
 */
public class ReasonMLLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_VALUE = 2;
  public static final int INITIAL = 4;
  public static final int IN_STRING = 6;
  public static final int IN_COMMENT = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\103\1\1\1\105\1\3\1\2\22\0\1\103\1\75\1\52\1\73\2\0\1\55\1\6\1\65"+
    "\1\66\1\54\1\101\1\63\1\27\1\24\1\53\1\11\1\23\2\104\4\20\2\7\1\56\1\64\1"+
    "\77\1\57\1\60\1\74\1\62\1\15\1\22\2\15\1\26\1\15\7\5\1\50\1\17\1\31\2\5\1"+
    "\51\4\5\1\13\2\5\1\71\1\102\1\72\1\100\1\10\1\76\1\35\1\21\1\42\1\37\1\25"+
    "\1\14\1\4\1\47\1\41\2\4\1\36\1\32\1\40\1\16\1\30\1\4\1\44\1\45\1\34\1\33\1"+
    "\4\1\46\1\12\1\43\1\4\1\67\1\61\1\70\7\0\1\105\242\0\2\105\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\3\1\4\1\5\1\6\2\7"+
    "\2\4\1\10\1\4\1\11\10\4\2\5\1\12\1\13"+
    "\1\14\1\2\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\2"+
    "\1\42\3\41\1\7\1\43\1\0\2\7\1\0\5\4"+
    "\1\44\5\4\1\45\2\4\1\46\3\4\2\5\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
    "\1\60\1\61\1\0\1\41\1\0\3\41\1\62\1\63"+
    "\2\43\1\0\3\7\1\64\12\4\1\65\2\4\1\66"+
    "\1\4\2\5\1\67\3\0\1\43\1\7\1\4\1\70"+
    "\2\4\1\71\2\4\1\72\1\73\1\74\1\75\2\4"+
    "\1\76\1\77\1\0\1\43\1\100\6\4\1\101\1\4"+
    "\1\102\2\4\1\103\1\4\1\104\1\105\1\106";

  private static int [] zzUnpackAction() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\106\0\214\0\322\0\u0118\0\u015e\0\u015e\0\u01a4"+
    "\0\u01ea\0\u0230\0\u015e\0\u0276\0\u02bc\0\u0302\0\u0348\0\u015e"+
    "\0\u038e\0\u03d4\0\u041a\0\u0460\0\u04a6\0\u04ec\0\u0532\0\u0578"+
    "\0\u05be\0\u0604\0\u064a\0\u0690\0\u015e\0\u06d6\0\u071c\0\u0762"+
    "\0\u07a8\0\u07ee\0\u015e\0\u0834\0\u015e\0\u015e\0\u015e\0\u015e"+
    "\0\u015e\0\u015e\0\u015e\0\u015e\0\u015e\0\u015e\0\u015e\0\u015e"+
    "\0\u015e\0\u087a\0\u015e\0\u08c0\0\u015e\0\u0906\0\u015e\0\u094c"+
    "\0\u0992\0\u09d8\0\u015e\0\u0a1e\0\u0a64\0\u0aaa\0\u0af0\0\u0b36"+
    "\0\u0b7c\0\u0bc2\0\u0c08\0\u0c4e\0\u0c94\0\u015e\0\u0cda\0\u0d20"+
    "\0\u0d66\0\u0dac\0\u0df2\0\u01ea\0\u0e38\0\u0e7e\0\u01ea\0\u0ec4"+
    "\0\u0f0a\0\u0f50\0\u0f96\0\u0fdc\0\u015e\0\u015e\0\u015e\0\u015e"+
    "\0\u015e\0\u015e\0\u1022\0\u015e\0\u015e\0\u015e\0\u015e\0\u0906"+
    "\0\u1068\0\u10ae\0\u10f4\0\u113a\0\u1180\0\u015e\0\u015e\0\u015e"+
    "\0\u11c6\0\u120c\0\u1252\0\u1298\0\u12de\0\u01ea\0\u1324\0\u136a"+
    "\0\u13b0\0\u13f6\0\u143c\0\u1482\0\u14c8\0\u150e\0\u1554\0\u159a"+
    "\0\u01ea\0\u15e0\0\u1626\0\u01ea\0\u166c\0\u16b2\0\u16f8\0\u015e"+
    "\0\u173e\0\u1784\0\u17ca\0\u1810\0\u0a64\0\u1856\0\u01ea\0\u189c"+
    "\0\u18e2\0\u01ea\0\u1928\0\u196e\0\u01ea\0\u01ea\0\u01ea\0\u01ea"+
    "\0\u19b4\0\u19fa\0\u0230\0\u0230\0\u1a40\0\u0a64\0\u01ea\0\u1a86"+
    "\0\u1acc\0\u1b12\0\u1b58\0\u1b9e\0\u1be4\0\u01ea\0\u1c2a\0\u01ea"+
    "\0\u1c70\0\u1cb6\0\u01ea\0\u1cfc\0\u01ea\0\u01ea\0\u01ea";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\106\6\107\7\3\10\1\11\1\12\1\13\1\14\1\11"+
    "\1\15\1\11\1\12\1\16\1\12\1\17\1\12\1\14"+
    "\1\11\1\12\1\14\1\20\1\21\1\12\1\22\1\11"+
    "\1\12\1\23\1\24\1\25\1\26\1\27\2\11\1\30"+
    "\2\11\1\31\1\32\2\11\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\1\62\1\63\1\64\1\7\1\10"+
    "\1\14\1\7\2\65\1\66\1\7\46\65\1\67\27\65"+
    "\1\70\2\65\1\7\2\65\1\66\1\7\47\65\1\71"+
    "\1\72\30\65\1\7\107\0\3\10\77\0\1\10\6\0"+
    "\20\11\1\0\2\11\1\0\22\11\32\0\1\11\5\0"+
    "\20\12\1\0\2\12\1\0\22\12\32\0\1\12\5\0"+
    "\2\73\1\0\3\14\2\73\2\0\2\73\1\14\2\0"+
    "\1\14\1\74\2\75\1\0\5\73\1\0\1\73\1\0"+
    "\2\73\1\0\7\73\32\0\1\14\5\0\2\73\1\0"+
    "\3\14\2\76\2\0\2\77\1\14\2\100\1\14\1\74"+
    "\2\75\1\0\5\73\1\0\1\73\1\0\2\73\1\0"+
    "\7\73\32\0\1\14\5\0\20\11\1\0\2\11\1\0"+
    "\3\11\1\101\1\11\1\102\14\11\32\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\1\103\21\11\32\0\1\11"+
    "\5\0\6\11\1\104\11\11\1\0\2\11\1\0\6\11"+
    "\1\105\13\11\32\0\1\11\25\0\1\106\65\0\12\11"+
    "\1\107\5\11\1\0\2\11\1\0\3\11\1\110\16\11"+
    "\32\0\1\11\5\0\20\11\1\0\2\11\1\0\10\11"+
    "\1\111\11\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\13\11\1\112\1\113\5\11\32\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\15\11\1\114\4\11\32\0"+
    "\1\11\5\0\20\11\1\0\1\115\1\11\1\0\11\11"+
    "\1\116\10\11\32\0\1\11\5\0\10\11\1\117\7\11"+
    "\1\0\2\11\1\0\10\11\1\120\11\11\32\0\1\11"+
    "\5\0\20\11\1\0\1\121\1\11\1\0\22\11\32\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\16\11\1\122"+
    "\3\11\32\0\1\11\5\0\12\12\1\123\5\12\1\0"+
    "\2\12\1\0\22\12\32\0\1\12\5\0\12\12\1\124"+
    "\5\12\1\0\2\12\1\0\22\12\32\0\1\12\25\0"+
    "\1\125\27\0\1\126\3\0\1\127\51\0\1\130\136\0"+
    "\1\131\106\0\1\132\106\0\1\133\1\134\105\0\1\135"+
    "\100\0\1\136\56\0\1\137\62\0\1\65\1\140\103\0"+
    "\1\65\1\141\1\142\1\0\3\65\1\143\1\65\1\143"+
    "\1\144\3\65\1\145\1\65\1\143\2\65\1\143\60\65"+
    "\1\143\55\0\1\146\104\0\1\147\36\0\2\150\1\0"+
    "\3\74\2\150\2\0\2\150\1\74\2\0\1\74\1\0"+
    "\2\75\1\0\5\150\1\0\1\150\1\0\2\150\1\0"+
    "\7\150\32\0\1\74\10\0\1\151\1\0\1\151\6\0"+
    "\1\151\2\0\1\151\3\0\1\152\51\0\1\152\2\0"+
    "\1\151\10\0\1\153\1\0\1\153\2\0\2\153\2\0"+
    "\4\153\1\0\2\153\6\0\1\153\1\0\1\153\2\0"+
    "\1\153\41\0\1\153\12\0\1\154\6\0\1\154\2\0"+
    "\1\154\60\0\1\154\12\0\1\155\11\0\1\155\66\0"+
    "\20\11\1\0\2\11\1\0\10\11\1\156\11\11\32\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\6\11\1\157"+
    "\13\11\32\0\1\11\5\0\20\11\1\0\1\160\1\11"+
    "\1\0\4\11\1\161\15\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\4\11\1\162\15\11\32\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\15\11\1\163\4\11"+
    "\32\0\1\11\5\0\20\11\1\0\2\11\1\0\7\11"+
    "\1\164\12\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\4\11\1\165\15\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\11\11\1\166\10\11\32\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\1\167\21\11\32\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\3\11\1\170"+
    "\16\11\32\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\4\11\1\171\15\11\32\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\15\11\1\172\4\11\32\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\12\11\1\173\7\11\32\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\12\11\1\174"+
    "\7\11\32\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\11\11\1\175\10\11\32\0\1\11\5\0\20\12\1\0"+
    "\2\12\1\0\10\12\1\176\11\12\32\0\1\12\5\0"+
    "\20\12\1\0\2\12\1\0\2\12\1\177\17\12\32\0"+
    "\1\12\60\0\1\200\131\0\1\141\3\0\1\141\1\142"+
    "\112\0\1\201\1\0\1\201\6\0\1\201\2\0\1\201"+
    "\60\0\1\201\10\0\1\202\1\0\1\202\2\0\2\202"+
    "\2\0\4\202\1\0\2\202\6\0\1\202\1\0\1\202"+
    "\2\0\1\202\41\0\1\202\12\0\1\203\11\0\1\203"+
    "\60\0\1\203\5\0\2\150\1\0\3\151\2\150\2\0"+
    "\2\150\1\151\2\0\1\151\4\0\5\150\1\0\1\150"+
    "\1\0\2\150\1\0\7\150\32\0\1\151\10\0\1\151"+
    "\1\0\1\151\6\0\1\151\2\0\1\151\60\0\1\151"+
    "\5\0\2\73\1\0\3\153\2\73\2\153\2\73\4\153"+
    "\1\204\2\153\1\0\2\205\3\73\1\153\1\73\1\153"+
    "\2\73\1\153\7\73\32\0\1\153\5\0\2\73\2\0"+
    "\2\154\2\73\2\0\2\73\1\154\2\0\1\154\4\0"+
    "\5\73\1\0\1\73\1\0\2\73\1\0\7\73\32\0"+
    "\1\154\5\0\2\73\2\0\2\155\2\73\2\0\2\73"+
    "\3\0\1\155\4\0\5\73\1\0\1\73\1\0\2\73"+
    "\1\0\7\73\40\0\20\11\1\0\2\11\1\0\15\11"+
    "\1\206\4\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\10\11\1\207\11\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\11\11\1\210\10\11\32\0\1\11"+
    "\5\0\20\11\1\0\1\211\1\11\1\0\22\11\32\0"+
    "\1\11\5\0\20\11\1\0\1\212\1\11\1\0\22\11"+
    "\32\0\1\11\5\0\20\11\1\0\2\11\1\0\3\11"+
    "\1\213\16\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\5\11\1\214\14\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\4\11\1\215\15\11\32\0\1\11"+
    "\5\0\20\11\1\0\1\216\1\11\1\0\22\11\32\0"+
    "\1\11\5\0\20\11\1\0\1\217\1\11\1\0\22\11"+
    "\32\0\1\11\5\0\20\11\1\0\2\11\1\0\4\11"+
    "\1\220\15\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\6\11\1\221\13\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\4\11\1\222\15\11\32\0\1\11"+
    "\5\0\20\12\1\0\1\223\1\12\1\0\22\12\32\0"+
    "\1\12\5\0\20\12\1\0\1\224\1\12\1\0\22\12"+
    "\32\0\1\12\10\0\1\65\1\0\1\65\6\0\1\65"+
    "\2\0\1\65\60\0\1\65\10\0\1\65\1\0\1\65"+
    "\2\0\2\65\2\0\4\65\1\0\2\65\6\0\1\65"+
    "\1\0\1\65\2\0\1\65\41\0\1\65\12\0\1\225"+
    "\6\0\1\225\2\0\1\225\60\0\1\225\5\0\2\150"+
    "\1\0\3\204\2\150\2\204\2\150\4\204\1\0\2\204"+
    "\1\0\2\226\3\150\1\204\1\150\1\204\2\150\1\204"+
    "\7\150\32\0\1\204\5\0\20\11\1\0\1\227\1\11"+
    "\1\0\22\11\32\0\1\11\5\0\12\11\1\230\5\11"+
    "\1\0\2\11\1\0\22\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\14\11\1\231\5\11\32\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\6\11\1\232\13\11"+
    "\32\0\1\11\5\0\15\11\1\233\2\11\1\0\2\11"+
    "\1\0\22\11\32\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\3\11\1\234\16\11\32\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\12\11\1\235\7\11\32\0\1\11"+
    "\12\0\1\65\6\0\1\65\2\0\1\65\60\0\1\65"+
    "\5\0\20\11\1\0\2\11\1\0\10\11\1\236\11\11"+
    "\32\0\1\11\5\0\20\11\1\0\2\11\1\0\10\11"+
    "\1\237\11\11\32\0\1\11\5\0\20\11\1\0\1\240"+
    "\1\11\1\0\22\11\32\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\6\11\1\241\13\11\32\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\7\11\1\242\12\11\32\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\17\11\1\243"+
    "\2\11\32\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\5\11\1\244\14\11\32\0\1\11\5\0\20\11\1\0"+
    "\1\245\1\11\1\0\22\11\32\0\1\11\5\0\20\11"+
    "\1\0\1\246\1\11\1\0\22\11\32\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\6\11\1\247\13\11\32\0"+
    "\1\11\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7490];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\2\11\3\1\1\11\4\1\1\11\14\1\1\11"+
    "\5\1\1\11\1\1\15\11\1\1\1\11\1\1\1\11"+
    "\1\1\1\11\3\1\1\11\1\1\1\0\2\1\1\0"+
    "\5\1\1\11\16\1\6\11\1\1\4\11\1\0\1\1"+
    "\1\0\3\1\3\11\1\1\1\0\25\1\1\11\3\0"+
    "\21\1\1\0\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int commentDepth;

  //Store the start index of a token
  private void tokenStart() {
    tokenStartIndex = zzStartRead;
  }

  //Set the start index of the token to the stored index
  private void tokenEnd() {
    zzStartRead = tokenStartIndex;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ReasonMLLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        switch (zzLexicalState) {
            case IN_STRING: {
              yybegin(INITIAL); tokenEnd(); return STRING;
            }
            case 168: break;
            case IN_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return COMMENT;
            }
            case 169: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(INITIAL); yypushback(1);
            }
          case 71: break;
          case 2: 
            { return BAD_CHARACTER;
            }
          case 72: break;
          case 3: 
            { return WHITE_SPACE;
            }
          case 73: break;
          case 4: 
            { return LIDENT;
            }
          case 74: break;
          case 5: 
            { return UIDENT;
            }
          case 75: break;
          case 6: 
            { return QUOTE;
            }
          case 76: break;
          case 7: 
            { return INT;
            }
          case 77: break;
          case 8: 
            { return DOT;
            }
          case 78: break;
          case 9: 
            { return MINUS;
            }
          case 79: break;
          case 10: 
            { yybegin(IN_STRING); tokenStart();
            }
          case 80: break;
          case 11: 
            { return SLASH;
            }
          case 81: break;
          case 12: 
            { return STAR;
            }
          case 82: break;
          case 13: 
            { return COLON;
            }
          case 83: break;
          case 14: 
            { return EQ;
            }
          case 84: break;
          case 15: 
            { return GT;
            }
          case 85: break;
          case 16: 
            { return PIPE;
            }
          case 86: break;
          case 17: 
            { return ARROBASE;
            }
          case 87: break;
          case 18: 
            { return COMMA;
            }
          case 88: break;
          case 19: 
            { return SEMI;
            }
          case 89: break;
          case 20: 
            { return LPAREN;
            }
          case 90: break;
          case 21: 
            { return RPAREN;
            }
          case 91: break;
          case 22: 
            { return LBRACE;
            }
          case 92: break;
          case 23: 
            { return RBRACE;
            }
          case 93: break;
          case 24: 
            { return LBRACKET;
            }
          case 94: break;
          case 25: 
            { return RBRACKET;
            }
          case 95: break;
          case 26: 
            { return SHARP;
            }
          case 96: break;
          case 27: 
            { return QUESTION_MARK;
            }
          case 97: break;
          case 28: 
            { return EXCLAMATION_MARK;
            }
          case 98: break;
          case 29: 
            { return BACKTICK;
            }
          case 99: break;
          case 30: 
            { return LT;
            }
          case 100: break;
          case 31: 
            { return CARRET;
            }
          case 101: break;
          case 32: 
            { return PLUS;
            }
          case 102: break;
          case 33: 
            { 
            }
          case 103: break;
          case 34: 
            { yybegin(INITIAL); tokenEnd(); return STRING;
            }
          case 104: break;
          case 35: 
            { return FLOAT;
            }
          case 105: break;
          case 36: 
            { return MINUSDOT;
            }
          case 106: break;
          case 37: 
            { return AS;
            }
          case 107: break;
          case 38: 
            { return IF;
            }
          case 108: break;
          case 39: 
            { return SLASHDOT;
            }
          case 109: break;
          case 40: 
            { yybegin(IN_COMMENT); commentDepth = 1; tokenStart();
            }
          case 110: break;
          case 41: 
            { return AUTO_CLOSE_TAG;
            }
          case 111: break;
          case 42: 
            { return STARDOT;
            }
          case 112: break;
          case 43: 
            { return ANDAND;
            }
          case 113: break;
          case 44: 
            { return SHORTCUT;
            }
          case 114: break;
          case 45: 
            { return EQEQ;
            }
          case 115: break;
          case 46: 
            { return ARROW;
            }
          case 116: break;
          case 47: 
            { return PIPE_FORWARD;
            }
          case 117: break;
          case 48: 
            { return CLOSE_TAG;
            }
          case 118: break;
          case 49: 
            { return PLUSDOT;
            }
          case 119: break;
          case 50: 
            { commentDepth += 1;
            }
          case 120: break;
          case 51: 
            { commentDepth -= 1; if(commentDepth == 0) { yybegin(INITIAL); tokenEnd(); return COMMENT; }
            }
          case 121: break;
          case 52: 
            { return FUN;
            }
          case 122: break;
          case 53: 
            { return LET;
            }
          case 123: break;
          case 54: 
            { return REC;
            }
          case 124: break;
          case 55: 
            { return EQEQEQ;
            }
          case 125: break;
          case 56: 
            { return OPEN;
            }
          case 126: break;
          case 57: 
            { return ELSE;
            }
          case 127: break;
          case 58: 
            { return UNIT;
            }
          case 128: break;
          case 59: 
            { return TYPE;
            }
          case 129: break;
          case 60: 
            { return TRUE;
            }
          case 130: break;
          case 61: 
            { return LIST;
            }
          case 131: break;
          case 62: 
            { return NONE;
            }
          case 132: break;
          case 63: 
            { return SOME;
            }
          case 133: break;
          case 64: 
            { return FALSE;
            }
          case 134: break;
          case 65: 
            { return OPTION;
            }
          case 135: break;
          case 66: 
            { return MODULE;
            }
          case 136: break;
          case 67: 
            { return SWITCH;
            }
          case 137: break;
          case 68: 
            { return MUTABLE;
            }
          case 138: break;
          case 69: 
            { return INCLUDE;
            }
          case 139: break;
          case 70: 
            { return EXTERNAL;
            }
          case 140: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
