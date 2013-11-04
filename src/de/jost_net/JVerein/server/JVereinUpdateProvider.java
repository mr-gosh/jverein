/**********************************************************************
 * $Source$
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) by Heiner Jostkleigrewe
 * This program is free software: you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See 
 *  the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, 
 * see <http://www.gnu.org/licenses/>.
 * 
 * heiner@jverein.de
 * www.jverein.de
 **********************************************************************/
package de.jost_net.JVerein.server;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.jost_net.JVerein.Variable.MitgliedVar;
import de.jost_net.JVerein.Variable.MitgliedskontoVar;
import de.jost_net.JVerein.keys.Zahlungsweg;
import de.jost_net.JVerein.rmi.JVereinDBService;
import de.willuhn.logging.Logger;
import de.willuhn.sql.ScriptExecutor;
import de.willuhn.util.ApplicationException;
import de.willuhn.util.ProgressMonitor;

public class JVereinUpdateProvider
{

  private Connection conn;

  private ProgressMonitor progressmonitor;

  private StringBuilder sb;

  private String driver;

  private static final String MYSQL = DBSupportMySqlImpl.class.getName();

  private static final String H2 = DBSupportH2Impl.class.getName();

  public JVereinUpdateProvider(Connection conn, ProgressMonitor progressmonitor)
      throws ApplicationException
  {
    this.conn = conn;
    this.progressmonitor = progressmonitor;
    driver = JVereinDBService.SETTINGS.getString("database.driver", H2);

    int cv = getCurrentVersion();
    if (cv == 0)
    {
      install(conn);
    }
    if (cv < 16)
    {
      update0016(conn);
    }
    if (cv < 17)
    {
      update0017(conn);
    }
    if (cv < 18)
    {
      update0018(conn);
    }
    if (cv < 19)
    {
      update0019(conn);
    }
    if (cv < 20)
    {
      update0020(conn);
    }
    if (cv < 21)
    {
      update0021(conn);
    }
    if (cv < 22)
    {
      update0022(conn);
    }
    if (cv < 23)
    {
      update0023(conn);
    }
    if (cv < 24)
    {
      update0024(conn);
    }
    if (cv < 25)
    {
      update0025(conn);
    }
    if (cv < 26)
    {
      update0026(conn);
    }
    if (cv < 27)
    {
      update0027(conn);
    }
    if (cv < 28)
    {
      update0028(conn);
    }
    if (cv < 29)
    {
      update0029(conn);
    }
    if (cv < 30)
    {
      update0030(conn);
    }
    if (cv < 31)
    {
      update0031(conn);
    }
    if (cv < 32)
    {
      update0032(conn);
    }
    if (cv < 33)
    {
      update0033(conn);
    }
    if (cv < 34)
    {
      update0034(conn);
    }
    if (cv < 35)
    {
      update0035(conn);
    }
    if (cv < 36)
    {
      update0036(conn);
    }
    if (cv < 37)
    {
      update0037(conn);
    }
    if (cv < 38)
    {
      update0038(conn);
    }
    if (cv < 39)
    {
      update0039(conn);
    }
    if (cv < 40)
    {
      update0040(conn);
    }
    if (cv < 41)
    {
      update0041(conn);
    }
    if (cv < 42)
    {
      update0042(conn);
    }
    if (cv < 43)
    {
      update0043(conn);
    }
    if (cv < 44)
    {
      update0044(conn);
    }
    if (cv < 45)
    {
      update0045(conn);
    }
    if (cv < 46)
    {
      update0046(conn);
    }
    if (cv < 47)
    {
      update0047(conn);
    }
    if (cv < 48)
    {
      update0048(conn);
    }
    if (cv < 49)
    {
      update0049(conn);
    }
    if (cv < 50)
    {
      update0050(conn);
    }
    if (cv < 51)
    {
      update0051(conn);
    }
    if (cv < 52)
    {
      update0052(conn);
    }
    if (cv < 53)
    {
      update0053(conn);
    }
    if (cv < 54)
    {
      update0054(conn);
    }
    if (cv < 55)
    {
      update0055(conn);
    }
    if (cv < 56)
    {
      update0056(conn);
    }
    if (cv < 57)
    {
      update0057(conn);
    }
    if (cv < 58)
    {
      update0058(conn);
    }
    if (cv < 59)
    {
      update0059(conn);
    }
    if (cv < 60)
    {
      update0060(conn);
    }
    if (cv < 61)
    {
      update0061(conn);
    }
    if (cv < 62)
    {
      update0062(conn);
    }
    if (cv < 63)
    {
      update0063(conn);
    }
    if (cv < 64)
    {
      update0064(conn);
    }
    if (cv < 65)
    {
      update0065(conn);
    }
    if (cv < 66)
    {
      update0066(conn);
    }
    if (cv < 67)
    {
      update0067(conn);
    }
    if (cv < 68)
    {
      update0068(conn);
    }
    if (cv < 69)
    {
      update0069(conn);
    }
    if (cv < 70)
    {
      update0070(conn);
    }
    if (cv < 71)
    {
      update0071(conn);
    }
    if (cv < 72)
    {
      update0072(conn);
    }
    if (cv < 73)
    {
      update0073(conn);
    }
    if (cv < 74)
    {
      update0074(conn);
    }
    if (cv < 75)
    {
      update0075(conn);
    }
    if (cv < 76)
    {
      update0076(conn);
    }
    if (cv < 77)
    {
      update0077(conn);
    }
    if (cv < 78)
    {
      update0078(conn);
    }
    if (cv < 79)
    {
      update0079(conn);
    }
    if (cv < 80)
    {
      update0080(conn);
    }
    if (cv < 81)
    {
      update0081(conn);
    }
    if (cv < 82)
    {
      update0082(conn);
    }
    if (cv < 83)
    {
      update0083(conn);
    }
    if (cv < 84)
    {
      update0084(conn);
    }
    if (cv < 85)
    {
      update0085(conn);
    }
    if (cv < 86)
    {
      update0086(conn);
    }
    if (cv < 87)
    {
      update0087(conn);
    }
    if (cv < 88)
    {
      update0088(conn);
    }
    if (cv < 89)
    {
      update0089(conn);
    }
    if (cv < 90)
    {
      update0090(conn);
    }
    if (cv < 91)
    {
      update0091(conn);
    }
    if (cv < 92)
    {
      update0092(conn);
    }
    if (cv < 93)
    {
      update0093(conn);
    }
    if (cv < 94)
    {
      update0094(conn);
    }
    if (cv < 95)
    {
      update0095(conn);
    }
    if (cv < 96)
    {
      update0096(conn);
    }
    if (cv < 97)
    {
      update0097(conn);
    }
    if (cv < 98)
    {
      update0098(conn);
    }
    if (cv < 99)
    {
      update0099(conn);
    }
    if (cv < 100)
    {
      update0100(conn);
    }
    if (cv < 101)
    {
      update0101(conn);
    }
    if (cv < 102)
    {
      update0102(conn);
    }
    if (cv < 103)
    {
      update0103(conn);
    }
    if (cv < 104)
    {
      update0104(conn);
    }
    if (cv < 105)
    {
      update0105(conn);
    }
    if (cv < 106)
    {
      update0106(conn);
    }
    if (cv < 107)
    {
      update0107(conn);
    }
    if (cv < 108)
    {
      update0108(conn);
    }
    if (cv < 109)
    {
      update0109(conn);
    }
    if (cv < 110)
    {
      update0110(conn);
    }
    if (cv < 111)
    {
      update0111(conn);
    }
    if (cv < 112)
    {
      update0112(conn);
    }
    if (cv < 113)
    {
      update0113(conn);
    }
    if (cv < 114)
    {
      update0114(conn);
    }
    if (cv < 115)
    {
      update0115(conn);
    }
    if (cv < 116)
    {
      update0116(conn);
    }
    if (cv < 117)
    {
      update0117(conn);
    }
    if (cv < 118)
    {
      update0118(conn);
    }
    if (cv < 119)
    {
      update0119(conn);
    }
    if (cv < 120)
    {
      update0120(conn);
    }
    if (cv < 121)
    {
      update0121(conn);
    }
    if (cv < 122)
    {
      update0122(conn);
    }
    if (cv < 123)
    {
      update0123(conn);
    }
    if (cv < 124)
    {
      update0124(conn);
    }
    if (cv < 125)
    {
      update0125(conn);
    }
    if (cv < 126)
    {
      update0126(conn);
    }
    if (cv < 127)
    {
      update0127(conn);
    }
    if (cv < 128)
    {
      update0128(conn);
    }
    if (cv < 129)
    {
      update0129(conn);
    }
    if (cv < 130)
    {
      update0130(conn);
    }
    if (cv < 131)
    {
      update0131(conn);
    }
    if (cv < 132)
    {
      update0132(conn);
    }
    if (cv < 133)
    {
      update0133(conn);
    }
    if (cv < 134)
    {
      update0134(conn);
    }
    if (cv < 135)
    {
      update0135(conn);
    }
    if (cv < 136)
    {
      update0136(conn);
    }
    if (cv < 137)
    {
      update0137(conn);
    }
    if (cv < 138)
    {
      update0138(conn);
    }
    if (cv < 139)
    {
      update0139(conn);
    }
    if (cv < 140)
    {
      update0140(conn);
    }
    if (cv < 141)
    {
      update0141(conn);
    }
    if (cv < 142)
    {
      update0142(conn);
    }
    if (cv < 143)
    {
      update0143(conn);
    }
    if (cv < 144)
    {
      update0144(conn);
    }
    if (cv < 145)
    {
      update0145(conn);
    }
    if (cv < 146)
    {
      update0146(conn);
    }
    if (cv < 147)
    {
      update0147(conn);
    }
    if (cv < 148)
    {
      update0148(conn);
    }
    if (cv < 149)
    {
      update0149(conn);
    }
    if (cv < 150)
    {
      update0150(conn);
    }
    if (cv < 151)
    {
      update0151(conn);
    }
    if (cv < 152)
    {
      update0152(conn);
    }
    if (cv < 153)
    {
      update0153(conn);
    }
    if (cv < 154)
    {
      update0154(conn);
    }
    if (cv < 155)
    {
      update0155(conn);
    }
    if (cv < 156)
    {
      update0156(conn);
    }
    if (cv < 157)
    {
      update0157(conn);
    }
    if (cv < 158)
    {
      update0158(conn);
    }
    if (cv < 159)
    {
      update0159(conn);
    }
    if (cv < 160)
    {
      update0160(conn);
    }
    if (cv < 161)
    {
      update0161(conn);
    }
    if (cv < 162)
    {
      update0162(conn);
    }
    if (cv < 163)
    {
      update0163(conn);
    }
    if (cv < 164)
    {
      update0164(conn);
    }
    if (cv < 165)
    {
      update0165(conn);
    }
    if (cv < 166)
    {
      update0166(conn);
    }
    if (cv < 167)
    {
      update0167(conn);
    }
    if (cv < 168)
    {
      update0168(conn);
    }
    if (cv < 169)
    {
      update0169(conn);
    }
    if (cv < 170)
    {
      update0170(conn);
    }
    if (cv < 171)
    {
      update0171(conn);
    }
    if (cv < 172)
    {
      update0172(conn);
    }
    if (cv < 173)
    {
      update0173(conn);
    }
    if (cv < 174)
    {
      update0174(conn);
    }
    if (cv < 175)
    {
      update0175(conn);
    }
    if (cv < 176)
    {
      update0176(conn);
    }
    if (cv < 177)
    {
      update0177(conn);
    }
    if (cv < 178)
    {
      update0178(conn);
    }
    if (cv < 179)
    {
      update0179(conn);
    }
    if (cv < 180)
    {
      update0180(conn);
    }
    if (cv < 181)
    {
      update0181(conn);
    }
    if (cv < 182)
    {
      update0182(conn);
    }
    if (cv < 183)
    {
      update0183(conn);
    }
    if (cv < 184)
    {
      update0184(conn);
    }
    if (cv < 185)
    {
      update0185(conn);
    }
    if (cv < 186)
    {
      update0186(conn);
    }
    if (cv < 187)
    {
      update0187(conn);
    }
    if (cv < 188)
    {
      update0188(conn);
    }
    if (cv < 189)
    {
      update0189(conn);
    }
    if (cv < 190)
    {
      update0190(conn);
    }
    if (cv < 191)
    {
      update0191(conn);
    }
    if (cv < 192)
    {
      update0192(conn);
    }
    if (cv < 193)
    {
      update0193(conn);
    }
    if (cv < 194)
    {
      update0194(conn);
    }
    if (cv < 195)
    {
      update0195(conn);
    }
    if (cv < 196)
    {
      update0196(conn);
    }
    if (cv < 197)
    {
      update0197(conn);
    }
    if (cv < 198)
    {
      update0198(conn);
    }
    if (cv < 199)
    {
      update0199(conn);
    }
    if (cv < 200)
    {
      update0200(conn);
    }
    if (cv < 201)
    {
      update0201(conn);
    }
    if (cv < 202)
    {
      update0202(conn);
    }
    if (cv < 203)
    {
      update0203(conn);
    }
    if (cv < 204)
    {
      update0204(conn);
    }
    if (cv < 205)
    {
      update0205(conn);
    }
    if (cv < 206)
    {
      update0206(conn);
    }
    if (cv < 207)
    {
      update0207(conn);
    }
    if (cv < 208)
    {
      update0208(conn);
    }
    if (cv < 209)
    {
      update0209(conn);
    }
    if (cv < 210)
    {
      update0210(conn);
    }
    if (cv < 211)
    {
      update0211(conn);
    }
    if (cv < 212)
    {
      update0212(conn);
    }
    if (cv < 213)
    {
      update0213(conn);
    }
    if (cv < 214)
    {
      update0214(conn);
    }
    if (cv < 215)
    {
      update0215(conn);
    }
    if (cv < 216)
    {
      update0216(conn);
    }
    if (cv < 217)
    {
      update0217(conn);
    }
    if (cv < 218)
    {
      update0218(conn);
    }
    if (cv < 219)
    {
      update0219(conn);
    }
    if (cv < 220)
    {
      update0220(conn);
    }
    if (cv < 221)
    {
      update0221(conn);
    }
    if (cv < 222)
    {
      update0222(conn);
    }
    if (cv < 223)
    {
      update0223(conn);
    }
    if (cv < 224)
    {
      update0224(conn);
    }
    if (cv < 225)
    {
      update0225(conn);
    }
    if (cv < 226)
    {
      update0226(conn);
    }
    if (cv < 227)
    {
      update0227(conn);
    }
    if (cv < 228)
    {
      update0228(conn);
    }
    if (cv < 229)
    {
      update0229(conn);
    }
    if (cv < 230)
    {
      update0230(conn);
    }
    if (cv < 231)
    {
      update0231(conn);
    }
    if (cv < 232)
    {
      update0232(conn);
    }
    if (cv < 233)
    {
      update0233(conn);
    }
    if (cv < 234)
    {
      update0234(conn);
    }
    if (cv < 235)
    {
      update0235(conn);
    }
    if (cv < 236)
    {
      update0236(conn);
    }
    if (cv < 237)
    {
      update0237(conn);
    }
    if (cv < 238)
    {
      update0238(conn);
    }
    if (cv < 239)
    {
      update0239(conn);
    }
    if (cv < 240)
    {
      update0240(conn);
    }
    if (cv < 241)
    {
      update0241(conn);
    }
    if (cv < 242)
    {
      update0242(conn);
    }
    if (cv < 243)
    {
      update0243(conn);
    }
    if (cv < 244)
    {
      update0244(conn);
    }
    if (cv < 245)
    {
      update0245(conn);
    }
    if (cv < 246)
    {
      update0246(conn);
    }
    if (cv < 247)
    {
      update0247(conn);
    }
    if (cv < 248)
    {
      update0248(conn);
    }
    if (cv < 249)
    {
      update0249(conn);
    }
    if (cv < 250)
    {
      update0250(conn);
    }
    if (cv < 251)
    {
      update0251(conn);
    }
    if (cv < 252)
    {
      update0252(conn);
    }
    if (cv < 253)
    {
      update0253(conn);
    }
    if (cv < 254)
    {
      update0254(conn);
    }
    if (cv < 255)
    {
      update0255(conn);
    }
    if (cv < 256)
    {
      update0256(conn);
    }
    if (cv < 257)
    {
      update0257(conn);
    }
    if (cv < 258)
    {
      update0258(conn);
    }
    if (cv < 259)
    {
      update0259(conn);
    }
    if (cv < 260)
    {
      update0260(conn);
    }
    if (cv < 261)
    {
      update0261(conn);
    }
    if (cv < 262)
    {
      update0262(conn);
    }
    if (cv < 263)
    {
      update0263(conn);
    }
    if (cv < 264)
    {
      update0264(conn);
    }
    if (cv < 265)
    {
      update0265(conn);
    }
    if (cv < 266)
    {
      update0266(conn);
    }
    if (cv < 267)
    {
      update0267(conn);
    }
    if (cv < 268)
    {
      update0268(conn);
    }
    if (cv < 269)
    {
      update0269(conn);
    }
    if (cv < 270)
    {
      update0270(conn);
    }
    if (cv < 271)
    {
      update0271(conn);
    }
    if (cv < 272)
    {
      update0272(conn);
    }
    if (cv < 273)
    {
      update0273(conn);
    }
    if (cv < 274)
    {
      update0274(conn);
    }
    if (cv < 275)
    {
      update0275(conn);
    }
    if (cv < 276)
    {
      update0276(conn);
    }
    if (cv < 277)
    {
      update0277(conn);
    }
    if (cv < 278)
    {
      update0278(conn);
    }
    if (cv < 279)
    {
      update0279(conn);
    }
    if (cv < 280)
    {
      update0280(conn);
    }
    if (cv < 281)
    {
      update0281(conn);
    }
    if (cv < 282)
    {
      update0282(conn);
    }
    if (cv < 283)
    {
      update0283(conn);
    }
    if (cv < 284)
    {
      update0284(conn);
    }
    if (cv < 285)
    {
      update0285(conn);
    }
    if (cv < 286)
    {
      update0286(conn);
    }
    if (cv < 287)
    {
      update0287(conn);
    }
    if (cv < 288)
    {
      update0288(conn);
    }
    if (cv < 289)
    {
      update0289(conn);
    }
    if (cv < 290)
    {
      update0290(conn);
    }
    if (cv < 291)
    {
      update0291(conn);
    }
    if (cv < 292)
    {
      update0292(conn);
    }
    if (cv < 293)
    {
      update0293(conn);
    }
    if (cv < 294)
    {
      update0294(conn);
    }
    if (cv < 295)
    {
      update0295(conn);
    }
    if (cv < 296)
    {
      update0296(conn);
    }
    if (cv < 297)
    {
      update0297(conn);
    }
    if (cv < 298)
    {
      update0298(conn);
    }
    if (cv < 299)
    {
      update0299(conn);
    }
    if (cv < 300)
    {
      update0300(conn);
    }
    if (cv < 301)
    {
      update0301(conn);
    }
    if (cv < 302)
    {
      update0302(conn);
    }
    if (cv < 303)
    {
      update0303(conn);
    }
    if (cv < 304)
    {
      update0304(conn);
    }
    if (cv < 305)
    {
      update0305(conn);
    }
    if (cv < 306)
    {
      update0306(conn);
    }
    if (cv < 307)
    {
      update0307(conn);
    }
    if (cv < 308)
    {
      update0308(conn);
    }
    if (cv < 309)
    {
      update0309(conn);
    }
    if (cv < 310)
    {
      update0310(conn);
    }
    if (cv < 311)
    {
      update0311(conn);
    }
    if (cv < 312)
    {
      update0312(conn);
    }
    if (cv < 313)
    {
      update0313(conn);
    }
    if (cv < 314)
    {
      update0314(conn);
    }
    if (cv < 315)
    {
      update0315(conn);
    }
    if (cv < 316)
    {
      update0316(conn);
    }
    if (cv < 317)
    {
      update0317(conn);
    }
    if (cv < 318)
    {
      update0318(conn);
    }
    if (cv < 319)
    {
      update0319(conn);
    }
    if (cv < 320)
    {
      update0320(conn);
    }
    if (cv < 321)
    {
      update0321(conn);
    }
    if (cv < 322)
    {
      update0322(conn);
    }
    if (cv < 323)
    {
      update0323(conn);
    }
    if (cv < 324)
    {
      update0324(conn);
    }
    if (cv < 325)
    {
      update0325(conn);
    }
    if (cv < 326)
    {
      update0326(conn);
    }
    if (cv < 327)
    {
      update0327(conn);
    }
    if (cv < 328)
    {
      update0328(conn);
    }
    if (cv < 329)
    {
      update0329(conn);
    }
    if (cv < 330)
    {
      update0330(conn);
    }
    if (cv < 331)
    {
      update0331(conn);
    }
    if (cv < 332)
    {
      update0332(conn);
    }
    if (cv < 333)
    {
      update0333(conn);
    }
    if (cv < 334)
    {
      update0334(conn);
    }
    if (cv < 335)
    {
      update0335(conn);
    }
    if (cv < 336)
    {
      update0336(conn);
    }
    if (cv < 337)
    {
      update0337(conn);
    }
    if (cv < 338)
    {
      update0338(conn);
    }
    if (cv < 339)
    {
      update0339(conn);
    }
    if (cv < 340)
    {
      update0340(conn);
    }
    if (cv < 341)
    {
      update0341(conn);
    }
    if (cv < 342)
    {
      update0342(conn);
    }
    if (cv < 343)
    {
      update0343(conn);
    }
    if (cv < 344)
    {
      update0344(conn);
    }
    if (cv < 345)
    {
      update0345(conn);
    }
    if (cv < 346)
    {
      update0346(conn);
    }
    if (cv < 347)
    {
      update0347(conn);
    }
    if (cv < 348)
    {
      update0348(conn);
    }
    if (cv < 349)
    {
      update0349(conn);
    }
    // TODO
  }

  public Connection getConnection()
  {
    return conn;
  }

  public int getCurrentVersion()
  {
    int ret = 0;
    try
    {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt
          .executeQuery("SELECT version FROM version WHERE id = 1");
      if (rs.next())
      {
        ret = rs.getInt(1);
      }
      rs.close();
      stmt.close();
    }
    catch (SQLException e)
    {
      return 0;
    }
    return ret;
  }

  public ProgressMonitor getProgressMonitor()
  {
    return progressmonitor;
  }

  public void setNewVersion(int newVersion) throws ApplicationException
  {
    try
    {
      String msg = "JVerein-DB-Update: " + newVersion;
      progressmonitor.setStatusText(msg);
      Logger.info(msg);
      Statement stmt = conn.createStatement();
      int anzahl = stmt.executeUpdate("UPDATE version SET version = "
          + newVersion + " WHERE id = 1");
      if (anzahl == 0)
      {
        stmt.executeUpdate("INSERT INTO version VALUES (1, " + newVersion + ")");
      }
      stmt.close();
    }
    catch (SQLException e)
    {
      Logger.error("Versionsnummer kann nicht eingef�gt werden.", e);
      throw new ApplicationException(
          "Versionsnummer kann nicht gespeichert werden.");
    }
  }

  public void execute(Connection conn, Map<String, String[]> statements,
      String logstring, int version, boolean dummy) throws ApplicationException
  {
    for (String driver : statements.keySet())
    {
      String[] sqls = statements.get(driver);
      for (String sql : sqls)
      {
        Map<String, String> stmt = new HashMap<String, String>();
        stmt.put(driver, sql);
        execute(conn, stmt, logstring, version);
      }
    }
  }

  public void execute(Connection conn, Map<String, String> statements,
      String logstring, int version) throws ApplicationException
  {
    System.out.println(version);
    Logger.info("TODO: " + logstring);
    String driver = JVereinDBService.SETTINGS.getString("database.driver",
        DBSupportH2Impl.class.getName());
    String sql = statements.get(driver);
    if (sql != null)
    {
      try
      {
        Logger.debug(sql);
        progressmonitor.log(logstring);
        ScriptExecutor.execute(new StringReader(sql), conn, null);
        setNewVersion(version);
      }
      catch (Exception e)
      {
        Logger.error("unable to execute update", e);
        throw new ApplicationException("Fehler beim Ausf�hren des Updates", e);
      }
    }
  }

  private void install(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitglied (");
    sb.append("id IDENTITY(1), ");
    sb.append("externemitgliedsnummer INTEGER,");
    sb.append("anrede VARCHAR(10),");
    sb.append("titel VARCHAR(20),");
    sb.append("name VARCHAR(40) NOT NULL, ");
    sb.append("vorname VARCHAR(40) NOT NULL,");
    sb.append("strasse VARCHAR(40) NOT NULL, ");
    sb.append("plz VARCHAR(10)  NOT NULL, ");
    sb.append("ort VARCHAR(40) NOT NULL, ");
    sb.append("zahlungsweg INTEGER,");
    sb.append("zahlungsrhytmus INTEGER,");
    sb.append("blz VARCHAR(8),");
    sb.append("konto VARCHAR(10),");
    sb.append("kontoinhaber VARCHAR(27),");
    sb.append("geburtsdatum DATE,");
    sb.append("geschlecht CHAR(1),");
    sb.append("telefonprivat VARCHAR(15),");
    sb.append("telefondienstlich VARCHAR(15),");
    sb.append("handy VARCHAR(15),");
    sb.append("email VARCHAR(50),");
    sb.append("eintritt DATE,");
    sb.append("beitragsgruppe INTEGER,");
    sb.append("zahlerid INTEGER,");
    sb.append("austritt DATE,");
    sb.append("kuendigung DATE,");
    sb.append("vermerk1 VARCHAR(255),");
    sb.append("vermerk2 VARCHAR(255),");
    sb.append("eingabedatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("UNIQUE (externemitgliedsnummer),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE TABLE beitragsgruppe(");
    sb.append("id IDENTITY(1),");
    sb.append("bezeichnung VARCHAR(30) NOT NULL,");
    sb.append("betrag DOUBLE,");
    sb.append("beitragsart INTEGER DEFAULT 0,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE mitglied ADD CONSTRAINT fkMitglied1 FOREIGN KEY (beitragsgruppe) REFERENCES beitragsgruppe (id) DEFERRABLE;\n");
    sb.append("CREATE TABLE zusatzabbuchung(");
    sb.append("id IDENTITY(1),");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("faelligkeit DATE NOT NULL,");
    sb.append("buchungstext VARCHAR(27) NOT NULL,");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("startdatum DATE,");
    sb.append("intervall INTEGER,");
    sb.append("endedatum DATE,");
    sb.append("ausfuehrung DATE,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE zusatzabbuchung ADD CONSTRAINT fkZusatzabbuchung1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) DEFERRABLE;\n");
    sb.append("CREATE TABLE stammdaten(");
    sb.append("id IDENTITY(1),");
    sb.append("name VARCHAR(30) NOT NULL,");
    sb.append("blz VARCHAR(8)  NOT NULL,");
    sb.append("konto VARCHAR(10) NOT NULL,");
    sb.append("altersgruppen VARCHAR(50),");
    sb.append("jubilaeen VARCHAR(50),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE TABLE kursteilnehmer (");
    sb.append("id IDENTITY(1),");
    sb.append("name VARCHAR(27) NOT NULL,");
    sb.append("vzweck1 VARCHAR(27) NOT NULL,");
    sb.append("vzweck2 VARCHAR(27),");
    sb.append("blz VARCHAR(8)  NOT NULL,");
    sb.append("konto VARCHAR(10) NOT NULL,");
    sb.append("betrag DOUBLE       NOT NULL,");
    sb.append("geburtsdatum DATE,");
    sb.append("geschlecht VARCHAR(1),");
    sb.append("eingabedatum  DATE NOT NULL,");
    sb.append("abbudatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("PRIMARY KEY (id));");
    sb.append("CREATE TABLE manuellerzahlungseingang (");
    sb.append("id IDENTITY(1), ");
    sb.append("name VARCHAR(27) NOT NULL,");
    sb.append("vzweck1 VARCHAR(27) NOT NULL,");
    sb.append("vzweck2 VARCHAR(27),");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("eingabedatum DATE NOT NULL,");
    sb.append("eingangsdatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE TABLE wiedervorlage(");
    sb.append("id IDENTITY(1),");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("datum DATE NOT NULL,");
    sb.append("vermerk VARCHAR(50) NOT NULL,");
    sb.append("erledigung DATE,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE wiedervorlage ADD CONSTRAINT fkWiedervorlage1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) DEFERRABLE;\n");
    sb.append("CREATE TABLE eigenschaften(");
    sb.append("id IDENTITY(1),");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("eigenschaft VARCHAR(50) NOT NULL,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE UNIQUE INDEX ixEigenschaften1 ON eigenschaften(mitglied, eigenschaft);\n");
    sb.append("CREATE TABLE `version` (");
    sb.append("`id` IDENTITY(1), ");
    sb.append("`version` INTEGER,");
    sb.append("UNIQUE (`id`), ");
    sb.append("PRIMARY KEY (`id`));\n");
    sb.append("create table felddefinition(");
    sb.append("id IDENTITY(1),");
    sb.append("name VARCHAR(50) NOT NULL,");
    sb.append("label VARCHAR(50) NOT NULL,");
    sb.append("laenge integer NOT NULL,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("create table zusatzfelder(");
    sb.append("id IDENTITY(1),");
    sb.append("mitglied integer NOT NULL,");
    sb.append("felddefinition integer NOT NULL,");
    sb.append("feld varchar(1000),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkZusatzfelder1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) DEFERRABLE;\n");
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkZusatzfelder2 FOREIGN KEY (felddefinition) REFERENCES felddefinition(id) ON DELETE CASCADE DEFERRABLE;\n");
    sb.append("CREATE TABLE konto (");
    sb.append("id IDENTITY(1),");
    sb.append("nummer VARCHAR(10),");
    sb.append("bezeichnung VARCHAR(30),");
    sb.append("eroeffnung DATE,");
    sb.append("aufloesung DATE,");
    sb.append("hibiscusid INTEGER,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (nummer),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE TABLE buchungsart (");
    sb.append("id IDENTITY(1),");
    sb.append("nummer INTEGER,");
    sb.append("bezeichnung VARCHAR(30),");
    sb.append("art INTEGER,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (nummer),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("CREATE TABLE buchung (");
    sb.append("id IDENTITY(1),");
    sb.append("umsatzid INTEGER,");
    sb.append("konto INTEGER  NOT NULL,");
    sb.append("name VARCHAR(100),");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("zweck VARCHAR(35),");
    sb.append("zweck2 VARCHAR(35),");
    sb.append("datum DATE NOT NULL,");
    sb.append("art VARCHAR(100),");
    sb.append("kommentar TEXT,");
    sb.append("buchungsart INTEGER,");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung1 FOREIGN KEY (buchungsart) REFERENCES buchungsart (id) DEFERRABLE;\n");
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung2 FOREIGN KEY (konto)       REFERENCES konto (id) DEFERRABLE;\n");
    sb.append("CREATE TABLE anfangsbestand (");
    sb.append("id IDENTITY(1),");
    sb.append("konto INTEGER,");
    sb.append("datum DATE,");
    sb.append("betrag DOUBLE,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (konto, datum),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE anfangsbestand ADD CONSTRAINT fkAnfangsbestand1 FOREIGN KEY (konto) REFERENCES konto (id) DEFERRABLE;\n");
    sb.append("CREATE TABLE jahresabschluss (");
    sb.append("id IDENTITY(1),");
    sb.append("von DATE,");
    sb.append("bis DATE,");
    sb.append("datum DATE,");
    sb.append("name VARCHAR(50),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id));\n");
    sb.append("INSERT INTO version VALUES (1,15);\n");
    sb.append("COMMIT;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitglied (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("externemitgliedsnummer int(10),");
    sb.append("anrede VARCHAR(10),");
    sb.append("titel VARCHAR(20),");
    sb.append("name VARCHAR(40) NOT NULL,");
    sb.append("vorname VARCHAR(40) NOT NULL,");
    sb.append("strasse VARCHAR(40) NOT NULL,");
    sb.append("plz VARCHAR(10)  NOT NULL,");
    sb.append("ort VARCHAR(40) NOT NULL,");
    sb.append("zahlungsweg INTEGER,");
    sb.append("zahlungsrhytmus INTEGER,");
    sb.append("blz VARCHAR(8),");
    sb.append("konto VARCHAR(10),");
    sb.append("kontoinhaber VARCHAR(27),");
    sb.append("geburtsdatum DATE,");
    sb.append("geschlecht CHAR(1),");
    sb.append("telefonprivat VARCHAR(15),");
    sb.append("telefondienstlich VARCHAR(15),");
    sb.append("handy VARCHAR(15),");
    sb.append("email VARCHAR(50),");
    sb.append("eintritt DATE,");
    sb.append("beitragsgruppe INTEGER,");
    sb.append("zahlerid INTEGER,");
    sb.append("austritt DATE,");
    sb.append("kuendigung DATE,");
    sb.append("vermerk1 VARCHAR(255),");
    sb.append("vermerk2 VARCHAR(255),");
    sb.append("eingabedatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("UNIQUE (externemitgliedsnummer),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE beitragsgruppe (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("bezeichnung VARCHAR(30) NOT NULL,");
    sb.append("betrag DOUBLE,");
    sb.append("beitragsart INTEGER DEFAULT 0,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE mitglied ADD CONSTRAINT fkMitglied1 FOREIGN KEY (beitragsgruppe) REFERENCES beitragsgruppe (id) ;\n");
    sb.append("CREATE TABLE zusatzabbuchung (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("faelligkeit DATE NOT NULL,");
    sb.append("buchungstext VARCHAR(27) NOT NULL,");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("startdatum DATE,");
    sb.append("intervall INTEGER,");
    sb.append("endedatum DATE,");
    sb.append("ausfuehrung DATE,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE zusatzabbuchung ADD CONSTRAINT fkZusatzabbuchung1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ;\n");
    sb.append("CREATE TABLE stammdaten (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("name VARCHAR(30) NOT NULL,");
    sb.append("blz VARCHAR(8)  NOT NULL,");
    sb.append("konto VARCHAR(10) NOT NULL,");
    sb.append("altersgruppen VARCHAR(50),");
    sb.append("jubilaeen VARCHAR(50),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE kursteilnehmer (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("name VARCHAR(27) NOT NULL,");
    sb.append("vzweck1 VARCHAR(27) NOT NULL,");
    sb.append("vzweck2 VARCHAR(27),");
    sb.append("blz VARCHAR(8)  NOT NULL,");
    sb.append("konto VARCHAR(10) NOT NULL,");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("geburtsdatum DATE,");
    sb.append("geschlecht VARCHAR(1),");
    sb.append("eingabedatum DATE NOT NULL,");
    sb.append("abbudatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE manuellerzahlungseingang (");
    sb.append("id int(10) AUTO_INCREMENT, ");
    sb.append("name VARCHAR(27) NOT NULL,");
    sb.append("vzweck1 VARCHAR(27) NOT NULL,");
    sb.append("vzweck2 VARCHAR(27),");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("eingabedatum DATE NOT NULL,");
    sb.append("eingangsdatum DATE,");
    sb.append("UNIQUE (id), ");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE wiedervorlage (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("datum DATE NOT NULL,");
    sb.append("vermerk VARCHAR(50) NOT NULL,");
    sb.append("erledigung DATE,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE wiedervorlage ADD CONSTRAINT fkWiedervorlage1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ;\n");
    sb.append("CREATE TABLE eigenschaften (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append("mitglied INTEGER NOT NULL,");
    sb.append("eigenschaft VARCHAR(50) NOT NULL,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("CREATE UNIQUE INDEX ixEigenschaften1 ON eigenschaften(mitglied, eigenschaft);\n");
    sb.append("CREATE TABLE `version` (");
    sb.append("`id` INTEGER AUTO_INCREMENT,");
    sb.append("`version` INTEGER,");
    sb.append("UNIQUE (`id`),");
    sb.append("PRIMARY KEY (`id`)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("create table felddefinition (");
    sb.append("id int(10) AUTO_INCREMENT,");
    sb.append(" name VARCHAR(50) NOT NULL,");
    sb.append("label VARCHAR(50) NOT NULL,");
    sb.append("laenge integer NOT NULL,");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("create table zusatzfelder (");
    sb.append("id integer auto_increment,");
    sb.append("mitglied integer NOT NULL,");
    sb.append("felddefinition integer NOT NULL,");
    sb.append("feld varchar(1000),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(") ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkZusatzfelder1 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n");
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkZusatzfelder2 FOREIGN KEY (felddefinition) REFERENCES felddefinition(id) ON DELETE CASCADE;\n");
    sb.append("CREATE TABLE konto (");
    sb.append("id INTEGER AUTO_INCREMENT,");
    sb.append("nummer VARCHAR(10),");
    sb.append("bezeichnung VARCHAR(30),");
    sb.append("eroeffnung DATE,");
    sb.append("aufloesung DATE,");
    sb.append("hibiscusid INTEGER,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (nummer),");
    sb.append("PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE buchungsart (");
    sb.append("id INTEGER AUTO_INCREMENT,");
    sb.append("nummer INTEGER,");
    sb.append("bezeichnung VARCHAR(30),");
    sb.append("art INTEGER,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (nummer),");
    sb.append("PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("CREATE TABLE buchung (");
    sb.append("id INTEGER AUTO_INCREMENT,");
    sb.append("umsatzid INTEGER,");
    sb.append("konto INTEGER  NOT NULL,");
    sb.append("name VARCHAR(100),");
    sb.append("betrag DOUBLE NOT NULL,");
    sb.append("zweck VARCHAR(35),");
    sb.append("zweck2 VARCHAR(35),");
    sb.append("datum DATE NOT NULL,");
    sb.append("art VARCHAR(100),");
    sb.append("kommentar TEXT,");
    sb.append("buchungsart   INTEGER,");
    sb.append("PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung1 FOREIGN KEY (buchungsart) REFERENCES buchungsart (id);\n");
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung2 FOREIGN KEY (konto)       REFERENCES konto (id);\n");
    sb.append("CREATE TABLE anfangsbestand (");
    sb.append("id INTEGER AUTO_INCREMENT,");
    sb.append("konto INTEGER,");
    sb.append("datum DATE,");
    sb.append("BETRAG DOUBLE,");
    sb.append("UNIQUE (id),");
    sb.append("UNIQUE (konto, datum),");
    sb.append("PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE anfangsbestand ADD CONSTRAINT fkAnfangsbestand1 FOREIGN KEY (konto) REFERENCES konto (id);\n");
    sb.append("CREATE TABLE jahresabschluss (");
    sb.append("id INTEGER AUTO_INCREMENT,");
    sb.append("von DATE,");
    sb.append("bis DATE,");
    sb.append("datum DATE,");
    sb.append("name VARCHAR(50),");
    sb.append("UNIQUE (id),");
    sb.append("PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("INSERT INTO version VALUES (1,15);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle jahresabschluss erstellt", 15);
  }

  private void update0016(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE formular (");
    sb.append("  id IDENTITY(1),");
    sb.append(" inhalt BLOB,");
    sb.append(" art integer,");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE formular (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" inhalt BLOB,");
    sb.append(" art integer,");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle formular erstellt", 16);
  }

  private void update0017(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE formularfeld(");
    sb.append(" id IDENTITY(1),");
    sb.append(" formular integer,");
    sb.append(" name VARCHAR(20),");
    sb.append(" x double,");
    sb.append(" y double,");
    sb.append(" font VARCHAR(20),");
    sb.append(" fontsize integer,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE formularfeld ADD CONSTRAINT fkFormularfeld1 FOREIGN KEY (formular) REFERENCES formular (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE formularfeld (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" formular integer,");
    sb.append(" name VARCHAR(20),");
    sb.append(" x double,");
    sb.append(" y double,");
    sb.append(" font VARCHAR(20),");
    sb.append(" fontsize integer,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE formularfeld ADD CONSTRAINT fkFormularfeld1 FOREIGN KEY (formular) REFERENCES formular (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle formularfeld erstellt", 17);
  }

  private void update0018(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchung alter column  kommentar varchar(1000);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchung modify column  kommentar varchar(1000);\n");

    execute(conn, statements, "Spalte kommentar der Tabelle buchung �ngert", 18);
  }

  private void update0019(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table formularfeld add fontstyle integer;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table formularfeld add fontstyle integer;\n");

    execute(conn, statements,
        "Spalte fontstyle zur Tabelle formularfeld hinzugef�gt", 19);
  }

  private void update0020(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE spendenbescheinigung (");
    sb.append(" id IDENTITY(1),");
    sb.append(" zeile1 VARCHAR(40),");
    sb.append(" zeile2 VARCHAR(40),");
    sb.append(" zeile3 VARCHAR(40),");
    sb.append(" zeile4 VARCHAR(40),");
    sb.append(" zeile5 VARCHAR(40),");
    sb.append(" zeile6 VARCHAR(40),");
    sb.append(" zeile7 VARCHAR(40),");
    sb.append(" spendedatum DATE,");
    sb.append(" bescheinigungsdatum DATE,");
    sb.append(" betrag DOUBLE,");
    sb.append(" formular INTEGER,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE spendenbescheinigung ADD CONSTRAINT fkSpendenbescheinigung1 FOREIGN KEY (formular) REFERENCES formular (id) ON DELETE RESTRICT;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE spendenbescheinigung (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" zeile1 VARCHAR(40),");
    sb.append(" zeile2 VARCHAR(40),");
    sb.append(" zeile3 VARCHAR(40),");
    sb.append(" zeile4 VARCHAR(40),");
    sb.append(" zeile5 VARCHAR(40),");
    sb.append(" zeile6 VARCHAR(40),");
    sb.append(" zeile7 VARCHAR(40),");
    sb.append(" spendedatum DATE,");
    sb.append(" bescheinigungsdatum DATE,");
    sb.append(" betrag DOUBLE,");
    sb.append(" formular INTEGER,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE spendenbescheinigung ADD CONSTRAINT fkSpendenbescheinigung1 FOREIGN KEY (formular) REFERENCES formular (id) ON DELETE RESTRICT;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle spendenbescheinigung erstellt", 20);
  }

  private void update0021(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "CREATE UNIQUE INDEX ixFormular1 ON formular(bezeichnung);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "CREATE UNIQUE INDEX ixFormular1 ON formular(bezeichnung);\n");

    execute(conn, statements, "Index f�r Tabelle formular erstellt", 21);
  }

  private void update0022(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE abrechnung (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" mitglied INTEGER,");
    sb.append(" datum DATE,");
    sb.append(" zweck1 VARCHAR(27),");
    sb.append(" zweck2 VARCHAR(27),");
    sb.append(" betrag DOUBLE,");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE abrechnung (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" mitglied INTEGER,");
    sb.append(" datum DATE,");
    sb.append(" zweck1 VARCHAR(27),");
    sb.append(" zweck2 VARCHAR(27),");
    sb.append(" betrag DOUBLE,");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle abrechnung erstellt", 22);
  }

  private void update0023(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "CREATE INDEX ixAbrechnung1 ON abrechnung(mitglied);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "CREATE INDEX ixAbrechnung1 ON abrechnung(mitglied);\n");

    execute(conn, statements, "Index f�r Tabelle abrechnung erstellt", 23);
  }

  private void update0024(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE abrechnung ADD CONSTRAINT fkAbrechnung1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE RESTRICT;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE abrechnung ADD CONSTRAINT fkAbrechnung1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE RESTRICT;\n");

    execute(conn, statements, "Foreign Key f�r Tabelle abrechnung erstellt", 24);
  }

  private void update0025(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE stammdaten ADD altersjubilaeen varchar(50);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE stammdaten ADD altersjubilaeen varchar(50);\n");

    execute(conn, statements,
        "Spalte altersjubilaeen in die Tabelle stammdaten eingef�gt", 25);
  }

  private void update0026(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE mitglied ADD adressierungszusatz varchar(40) before strasse;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE mitglied ADD adressierungszusatz varchar(40) after vorname;\n");

    execute(conn, statements,
        "Spalte adressierungszusatz in die Tabelle mitglied eingef�gt", 26);
  }

  private void update0027(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "UPDATE mitglied SET adressierungszusatz = '' WHERE adressierungszusatz is null;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "UPDATE mitglied SET adressierungszusatz = '' WHERE adressierungszusatz is null;\n");

    execute(
        conn,
        statements,
        "Spalte adressierungszusatz in der Tabelle auf '' (Leerstring) gesetzt",
        27);
  }

  private void update0028(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE einstellung (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" geburtsdatumpflicht CHAR(5),");
    sb.append(" eintrittsdatumpflicht CHAR(5),");
    sb.append(" kommunikationsdaten CHAR(5),");
    sb.append(" zusatzabbuchung CHAR(5),");
    sb.append(" vermerke CHAR(5),");
    sb.append(" wiedervorlage CHAR(5),");
    sb.append(" kursteilnehmer CHAR(5),");
    sb.append(" externemitgliedsnummer CHAR(5),");
    sb.append(" beitragsmodel INTEGER,");
    sb.append(" dateinamenmuster VARCHAR(50),");
    sb.append(" beginngeschaeftsjahr CHAR(6),");
    sb.append(" rechnungfuerabbuchung CHAR(5),");
    sb.append(" rechnungfuerueberweisung CHAR(5),");
    sb.append(" rechnungfuerbarzahlung CHAR(5),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE einstellung (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" geburtsdatumpflicht CHAR(5),");
    sb.append(" eintrittsdatumpflicht CHAR(5),");
    sb.append(" kommunikationsdaten CHAR(5),");
    sb.append(" zusatzabbuchung CHAR(5),");
    sb.append(" vermerke CHAR(5),");
    sb.append(" wiedervorlage CHAR(5),");
    sb.append(" kursteilnehmer CHAR(5),");
    sb.append(" externemitgliedsnummer CHAR(5),");
    sb.append(" beitragsmodel INTEGER,");
    sb.append(" dateinamenmuster VARCHAR(50),");
    sb.append(" beginngeschaeftsjahr CHAR(6),");
    sb.append(" rechnungfuerabbuchung CHAR(5),");
    sb.append(" rechnungfuerueberweisung CHAR(5),");
    sb.append(" rechnungfuerbarzahlung CHAR(5),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle einstellung erstellt", 28);
  }

  private void update0029(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE buchung ADD auszugsnummer integer before name;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE buchung ADD auszugsnummer integer after konto;\n");

    execute(conn, statements,
        "Spalte auszugsnummer in die Tabelle buchung eingef�gt", 29);
  }

  private void update0030(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE buchung ADD blattnummer integer before name;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE buchung ADD blattnummer integer after auszugsnummer;\n");

    execute(conn, statements,
        "Spalte blattnummer in die Tabelle buchung eingef�gt", 30);
  }

  private void update0031(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ALTER COLUMN telefonprivat varchar(20);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied MODIFY COLUMN telefonprivat varchar(20);\n");

    execute(conn, statements,
        "Spalte telefonprivat in der Tabelle mitglied �ngert", 31);
  }

  private void update0032(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ALTER COLUMN telefondienstlich varchar(20);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied MODIFY COLUMN telefondienstlich varchar(20);\n");

    execute(conn, statements,
        "Spalte telefondienstlich in der Tabelle mitglied �ngert", 32);
  }

  private void update0033(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ALTER COLUMN handy varchar(20);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied MODIFY COLUMN handy varchar(20);\n");

    execute(conn, statements, "Spalte handy in der Tabelle mitglied �ngert", 33);
  }

  private void update0034(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE spendenbescheinigung ADD ersatzaufwendungen char(5);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE spendenbescheinigung ADD ersatzaufwendungen char(5);\n");

    execute(
        conn,
        statements,
        "Spalte ersatzaufwendungen in die Tabelle spendenbescheinigung aufgenommen",
        34);
  }

  private void update0035(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE report");
    sb.append("(");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" art INTEGER,");
    sb.append(" quelle BLOB,");
    sb.append(" kompilat BLOB,");
    sb.append(" aenderung TIMESTAMP,");
    sb.append(" nutzung  TIMESTAMP,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE report");
    sb.append(" (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" art INTEGER,");
    sb.append(" quelle BLOB,");
    sb.append(" kompilat BLOB,");
    sb.append(" aenderung TIMESTAMP,");
    sb.append(" nutzung TIMESTAMP,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle report aufgenommen", 35);
  }

  private void update0036(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("drop table report;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("drop table report;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle report gel�scht", 36);
  }

  private void update0037(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table lehrgangsart (");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(50) NOT NULL,");
    sb.append(" von DATE,");
    sb.append(" bis DATE,");
    sb.append(" veranstalter VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table lehrgangsart (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(50) NOT NULL,");
    sb.append(" von DATE,");
    sb.append(" bis DATE,");
    sb.append(" veranstalter VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle lehrgangsart erstellt", 37);
  }

  private void update0038(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD lehrgaenge char(5) before externemitgliedsnummer;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD lehrgaenge char(5) after kursteilnehmer;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte lehrgaenge in die Tabelle lehrgangsart aufgenommen", 38);
  }

  private void update0039(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table lehrgang (");
    sb.append(" id IDENTITY(1),");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" lehrgangsart INTEGER NOT NULL,");
    sb.append(" von DATE,");
    sb.append(" bis DATE,");
    sb.append(" veranstalter VARCHAR(50),");
    sb.append(" ergebnis VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table lehrgang (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" lehrgangsart INTEGER NOT NULL,");
    sb.append(" von DATE,");
    sb.append(" bis DATE,");
    sb.append(" veranstalter VARCHAR(50),");
    sb.append(" ergebnis VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle lehrgang aufgenommen", 39);
  }

  private void update0040(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang aufgenommen",
        40);
  }

  private void update0041(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang2 FOREIGN KEY (lehrgangsart) REFERENCES lehrgangsart (id) DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang2 FOREIGN KEY (lehrgangsart) REFERENCES lehrgangsart (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang aufgenommen",
        41);
  }

  private void update0042(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang DROP CONSTRAINT fkLehrgang1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang DROP FOREIGN KEY fkLehrgang1;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang entfernt", 42);
  }

  private void update0043(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang DROP CONSTRAINT fkLehrgang2;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang DROP FOREIGN KEY fkLehrgang2;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang entfernt", 43);
  }

  private void update0044(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang eingerichtet",
        44);
  }

  private void update0045(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang2 FOREIGN KEY (lehrgangsart) REFERENCES lehrgangsart (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang2 FOREIGN KEY (lehrgangsart) REFERENCES lehrgangsart (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle lehrgang eingerichtet",
        45);
  }

  private void update0046(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE formular ALTER COLUMN inhalt LONGBLOB;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE formular MODIFY COLUMN inhalt LONGBLOB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Spalte inhalt der Tabelle formular �ngert", 46);
  }

  private void update0047(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD juristischepersonen char(5) before externemitgliedsnummer;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD juristischepersonen char(5) after lehrgaenge;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte juristischepersonen in die Tabelle einstellung aufgenommen", 47);
  }

  private void update0048(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD personenart char(1) before anrede;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD personenart char(1) after externemitgliedsnummer;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte personenart in die Tabelle mitglied aufgenommen", 48);
  }

  private void update0049(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("update mitglied set personenart = 'n';\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("update mitglied set personenart = 'n';\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Alle Mitglieder auf personenart 'n' gesetzt", 49);
  }

  private void update0050(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("alter table mitglied alter column vorname varchar(40) null;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("alter table mitglied modify column vorname varchar(40) null;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Spalte vorname in der Tabelle mitglied �ngert.",
        50);
  }

  private void update0051(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder DROP CONSTRAINT fkzusatzfelder1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder DROP FOREIGN KEY fkZusatzfelder1;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key der Tabelle zusatzfelder entfernt",
        51);
  }

  private void update0052(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkzusatzfelder1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD CONSTRAINT fkzusatzfelder1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Foreign Key der Tabelle zusatzfelder eingerichtet", 52);
  }

  private void update0053(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD aktuellegeburtstagevorher integer default 3 before externemitgliedsnummer;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD aktuellegeburtstagevorher integer default 3 after juristischepersonen;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte aktuellegeburtstagevorher in die Tabelle einstellung aufgenommen",
        53);
  }

  private void update0054(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD aktuellegeburtstagenachher integer default 7 before externemitgliedsnummer;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD aktuellegeburtstagenachher integer default 7 after aktuellegeburtstagevorher;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte aktuellegeburtstagenachher in die Tabelle einstellung aufgenommen",
        54);
  }

  private void update0055(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE buchungsklasse (");
    sb.append(" id IDENTITY(1),");
    sb.append(" nummer INTEGER,");
    sb.append(" bezeichnung VARCHAR(30),");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (nummer),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE buchungsklasse (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" nummer INTEGER,");
    sb.append(" bezeichnung VARCHAR(30),");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (nummer),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle buchungsklasse aufgenommen", 55);
  }

  private void update0056(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE `buchungsart` add COLUMN buchungsklasse INTEGER;\n");
    sb.append("CREATE INDEX buchungsart_2 on buchungsart(buchungsklasse);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE `buchungsart` add COLUMN buchungsklasse INTEGER;\n");
    sb.append("CREATE INDEX buchungsart_2 on buchungsart(buchungsklasse);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte buchungsklasse in die Tabelle buchungsart aufgenommen, Index zur Tabelle buchungsart aufgenommen",
        56);
  }

  private void update0057(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchungsart ADD CONSTRAINT fkBuchungsart2 FOREIGN KEY (buchungsklasse) REFERENCES buchungsklasse (id) DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchungsart ADD CONSTRAINT fkBuchungsart2 FOREIGN KEY (buchungsklasse) REFERENCES buchungsklasse (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Foreign Key zur Tabelle buchungsart hinzugef�gt", 57);
  }

  private void update0058(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updateinterval integer default 30;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updateinterval integer default 30;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte updateinterval zur Tabelle einstellung hinzugef�gt", 58);
  }

  private void update0059(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updatediaginfos char(5)default 'true';\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updatediaginfos char(5)default 'true';\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte updatediaginfos zur Tabelle einstellung hinzugef�gt", 59);
  }

  private void update0060(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updatelastcheck date;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD updatelastcheck date;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte updatelastcheck zur Tabelle einstellung hinzugef�gt", 60);
  }

  private void update0061(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("-- nothing to do\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("alter table `anfangsbestand` change BETRAG `betrag` double default NULL;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte betrag der Tabelle anfangsbestand ge�ndert", 61);
  }

  private void update0062(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_server varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_server varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_server in die Tabelle einstellung aufgenommen", 62);
  }

  private void update0063(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_port char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_port char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_port in die Tabelle einstellung aufgenommen", 63);
  }

  private void update0064(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_auth_user varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_auth_user varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_auth_user in die Tabelle einstellung aufgenommen", 64);
  }

  private void update0065(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_auth_pwd varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_auth_pwd varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_auth_pwd in die Tabelle einstellung aufgenommen", 65);
  }

  private void update0066(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_from_address varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_from_address varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_from_address in die Tabelle einstellung aufgenommen", 66);
  }

  private void update0067(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_ssl char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_ssl char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_ssl in die Tabelle einstellung aufgenommen", 67);
  }

  private void update0068(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE eigenschaftgruppe (");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(30) NOT NULL,");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE eigenschaftgruppe (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(30) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle eigenschaftgruppe aufgenommen", 68);
  }

  private void update0069(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE eigenschaft (");
    sb.append("id                IDENTITY(1),");
    sb.append("eigenschaftgruppe     INTEGER,");
    sb.append("bezeichnung     VARCHAR(30) NOT NULL,");
    sb.append("UNIQUE        (id),");
    sb.append("PRIMARY KEY   (id));\n");
    sb.append("ALTER TABLE eigenschaft ADD CONSTRAINT fkEigenschaft1 FOREIGN KEY (eigenschaftgruppe) REFERENCES eigenschaftgruppe (id) DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE eigenschaft (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append("eigenschaftgruppe     INTEGER,");
    sb.append(" bezeichnung VARCHAR(30) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE eigenschaft ADD CONSTRAINT fkEigenschaft1 FOREIGN KEY (eigenschaftgruppe) REFERENCES eigenschaftgruppe (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle eigenschaftgruppe aufgenommen", 69);
  }

  private void update0070(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ALTER COLUMN anrede varchar(40);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied MODIFY COLUMN anrede varchar(40);\n");

    execute(conn, statements, "Spalte anrede in der Tabelle mitglied �ngert",
        70);
  }

  private void update0071(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ALTER COLUMN titel varchar(40);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied MODIFY COLUMN titel varchar(40);\n");

    execute(conn, statements, "Spalte anrede in der Tabelle mitglied �ngert",
        71);
  }

  private void update0072(Connection conn) throws ApplicationException
  {
    try
    {
      List<String> eigenschaften = new ArrayList<String>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt
          .executeQuery("select eigenschaft from eigenschaften group by eigenschaft order by eigenschaft");
      while (rs.next())
      {
        eigenschaften.add(rs.getString(1));
      }
      rs.close();
      stmt.close();
      PreparedStatement pstmt = conn
          .prepareStatement("INSERT INTO eigenschaft (bezeichnung) values (?)");
      for (String eig : eigenschaften)
      {
        pstmt.setString(1, eig);
        pstmt.executeUpdate();
      }
      pstmt.close();
    }
    catch (Exception e)
    {
      Logger.error("kann Liste der Eigenschaften nicht aufbauen", e);
    }
    setNewVersion(72);
  }

  private void update0073(Connection conn) throws ApplicationException
  {
    try
    {
      Map<String, String> eigenschaften = new HashMap<String, String>();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt
          .executeQuery("select id, bezeichnung from eigenschaft");
      while (rs.next())
      {
        eigenschaften.put(rs.getString(1), rs.getString(2));
      }
      rs.close();
      stmt.close();
      PreparedStatement pstmt = conn
          .prepareStatement("UPDATE eigenschaften SET eigenschaft = ? WHERE eigenschaft = ?");
      for (String eig : eigenschaften.keySet())
      {
        pstmt.setString(1, eig);
        pstmt.setString(2, eigenschaften.get(eig));
        pstmt.executeUpdate();
      }
      pstmt.close();
    }
    catch (Exception e)
    {
      Logger.error("kann Liste der Eigenschaften nicht aufbauen", e);
    }
    setNewVersion(73);
  }

  private void update0074(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table eigenschaften alter column  eigenschaft integer not null;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table eigenschaften modify column  eigenschaft integer not null;\n");

    execute(conn, statements,
        "Typ der Spalte eigenschaft der Tabelle eigenschaften ver�ndert", 74);
  }

  private void update0075(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "INSERT INTO eigenschaftgruppe (id, bezeichnung) values ('1', 'keine Zuordnung');";
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Default-Wert in die Tabelle eigenschaftgruppe eingetragen", 75);
  }

  private void update0076(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "UPDATE eigenschaft SET eigenschaftgruppe = '1' WHERE eigenschaftgruppe IS NULL;";
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Default-Wert in die Tabelle eigenschaft eingetragen", 76);
  }

  private void update0077(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "CREATE UNIQUE INDEX ixEigenschaft1 ON eigenschaft(bezeichnung);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "CREATE UNIQUE INDEX ixEigenschaft1 ON eigenschaft(bezeichnung);\n");

    execute(conn, statements, "Index f�r Tabelle eigenschaft erstellt", 77);
  }

  private void update0078(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "CREATE UNIQUE INDEX ixEigenschaftGruppe1 ON eigenschaftgruppe(bezeichnung);\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "CREATE UNIQUE INDEX ixEigenschaftGruppe1 ON eigenschaftgruppe(bezeichnung);\n");

    execute(conn, statements, "Index f�r Tabelle eigenschaft erstellt", 78);
  }

  private void update0079(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN updateinterval;\n"
            + "ALTER TABLE einstellung DROP COLUMN updatediaginfos;\n"
            + "ALTER TABLE einstellung DROP COLUMN updatelastcheck;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN updateinterval, "
            + "DROP COLUMN updatediaginfos, DROP COLUMN updatelastcheck;\n");

    execute(conn, statements, "Spalten aus Tabelle einstellung entfernt", 79);
  }

  private void update0080(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE felddefinition ADD datentyp integer default 1 before laenge;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE felddefinition ADD datentyp integer default 1 after label;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte datentyp in die Tabelle felddefinition aufgenommen", 80);
  }

  private void update0081(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD felddatum DATE NULL;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD felddatum DATE NULL;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Div. Datentypen f. d. Zusatzfelder aufgenommen",
        81);
  }

  private void update0082(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldganzzahl integer NULL;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldganzzahl integer NULL;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Div. Datentypen f. d. Zusatzfelder aufgenommen",
        82);
  }

  private void update0083(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldgleitkommazahl DOUBLE null;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldgleitkommazahl DOUBLE null;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Div. Datentypen f. d. Zusatzfelder aufgenommen",
        83);
  }

  private void update0084(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldwaehrung DECIMAL(15,2);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldwaehrung DECIMAL(15,2);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Div. Datentypen f. d. Zusatzfelder aufgenommen",
        84);
  }

  private void update0085(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldjanein CHAR(5) NULL;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE zusatzfelder ADD feldjanein CHAR(5) NULL;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Div. Datentypen f. d. Zusatzfelder aufgenommen",
        85);
  }

  private void update0086(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zahlungsweg INT DEFAULT 1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zahlungsweg INT DEFAULT 1;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Default-Zahlungsweg in die Tabelle einstellung aufgenommen", 86);
  }

  private void update0087(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zahlungsrhytmus INT DEFAULT 12;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zahlungsrhytmus INT DEFAULT 12;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Default-Zahlungsrhytmus in die Tabelle einstellung aufgenommen", 87);
  }

  private void update0088(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailvorlage (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" betreff VARCHAR(100) NOT NULL,");
    sb.append(" txt VARCHAR(1000) NOT NULL,");
    sb.append(" UNIQUE (id), ");
    sb.append(" UNIQUE (betreff),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailvorlage (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" betreff VARCHAR(100) NOT NULL,");
    sb.append(" txt VARCHAR(1000),");
    sb.append(" UNIQUE (id), ");
    sb.append(" UNIQUE (betreff),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mailvorlage erstellt", 88);
  }

  private void update0089(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mail (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" betreff VARCHAR(100) NOT NULL,");
    sb.append(" txt VARCHAR(1000) NOT NULL,");
    sb.append(" bearbeitung TIMESTAMP NOT NULL, ");
    sb.append(" versand TIMESTAMP, ");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mail (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" betreff VARCHAR(100) NOT NULL,");
    sb.append(" txt VARCHAR(1000),");
    sb.append(" bearbeitung TIMESTAMP NOT NULL, ");
    sb.append(" versand TIMESTAMP, ");
    sb.append(" UNIQUE (id), ");
    sb.append("UNIQUE (betreff),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mail erstellt", 89);
  }

  private void update0090(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailempfaenger (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" mail INTEGER NOT NULL, ");
    sb.append(" mitglied INTEGER,");
    sb.append(" adresse VARCHAR(50),");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailempfaenger (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" mail INTEGER NOT NULL, ");
    sb.append(" mitglied INTEGER, ");
    sb.append(" adresse VARCHAR(50),");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Tabelle mailempfaenger erstellt", 90);
  }

  private void update0091(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailEmpfaenger1 FOREIGN KEY (mail) REFERENCES mail (id)  ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailEmpfaenger1 FOREIGN KEY (mail) REFERENCES mail (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 1 f�r mailempfaenger erstellt", 91);
  }

  private void update0092(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailEmpfaenger2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailEmpfaenger2 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 2 f�r mailempfaenger erstellt", 92);
  }

  private void update0093(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailanhang (");
    sb.append("  id IDENTITY(1), ");
    sb.append(" mail INTEGER NOT NULL, ");
    sb.append(" anhang BLOB,");
    sb.append(" dateiname VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mailanhang (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" mail INTEGER NOT NULL, ");
    sb.append(" anhang BLOB,");
    sb.append(" dateiname VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mailanhang erstellt", 93);
  }

  private void update0094(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailanhang ADD CONSTRAINT fkMailAnhang1 FOREIGN KEY (mail) REFERENCES mail (id)  ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailanhang ADD CONSTRAINT fkMailAnhang1 FOREIGN KEY (mail) REFERENCES mail (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 1 f�r mailempfaenger erstellt", 94);
  }

  private void update0095(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("DELETE FROM eigenschaften WHERE eigenschaften.id IN (select e.id from eigenschaften as e left join mitglied as m on e.mitglied = m.id where m.id is null  );\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("DELETE eigenschaften from eigenschaften left join mitglied on mitglied.id = eigenschaften.mitglied;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Fehlerhafte Eigenschaften entfernt", 95);

    statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE  DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) on delete cascade;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 1 f�r eigenschaften erstellt", 95);
  }

  private void update0096(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE abrechnungslauf (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" datum DATE NOT NULL,");
    sb.append(" modus INTEGER NOT NULL,");
    sb.append(" stichtag DATE, ");
    sb.append(" eingabedatum DATE, ");
    sb.append(" zahlungsgrund VARCHAR(27),");
    sb.append(" zusatzbetraege CHAR(5), ");
    sb.append(" kursteilnehmer CHAR(5), ");
    sb.append(" dtausdruck CHAR(5), ");
    sb.append(" abbuchungsausgabe INTEGER, ");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE abrechnungslauf (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" datum DATE NOT NULL,");
    sb.append(" modus INTEGER NOT NULL,");
    sb.append(" stichtag DATE, ");
    sb.append(" eingabedatum DATE, ");
    sb.append(" zahlungsgrund VARCHAR(27),");
    sb.append(" zusatzbetraege CHAR(5), ");
    sb.append(" kursteilnehmer CHAR(5), ");
    sb.append(" dtausdruck CHAR(5), ");
    sb.append(" abbuchungsausgabe INTEGER, ");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle abrechnungslauf erstellt", 96);
  }

  private void update0097(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitgliedskonto (");
    sb.append(" id IDENTITY(1), ");
    sb.append(" abrechnungslauf INTEGER,");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL,");
    sb.append(" zweck1 VARCHAR(27),");
    sb.append(" zweck2 VARCHAR(27),");
    sb.append(" zahlungsweg INTEGER, ");
    sb.append(" betrag DOUBLE,");
    sb.append(" UNIQUE (id), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitgliedskonto (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" abrechnungslauf INTEGER,");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL,");
    sb.append(" zweck1 VARCHAR(27),");
    sb.append(" zweck2 VARCHAR(27),");
    sb.append(" zahlungsweg INTEGER, ");
    sb.append(" betrag DOUBLE,");
    sb.append(" UNIQUE (id), ");
    sb.append(" INDEX(abrechnungslauf), ");
    sb.append(" INDEX(mitglied), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mitgliedskonto erstellt", 97);
  }

  private void update0098(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE  DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) on delete cascade;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 1 f�r mitgliedskonto erstellt", 98);
  }

  private void update0099(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE  DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) on delete cascade;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 2 f�r mitgliedskonto erstellt", 99);
  }

  private void update0100(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedskonto char(5) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedskonto char(5) after juristischepersonen;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte mitgliedskontistzahlung in die Tabelle einstellung aufgenommen",
        100);
  }

  private void update0101(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchung add mitgliedskonto integer;\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchung add mitgliedskonto integer;\n");

    execute(conn, statements,
        "Spalte mitgliedskonto zur Tabelle buchung hinzugef�gt", 101);
  }

  private void update0102(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung3 FOREIGN KEY (mitgliedskonto) REFERENCES mitgliedskonto (id)  ON DELETE CASCADE  DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung3 FOREIGN KEY (mitgliedskonto) REFERENCES mitgliedskonto (id)  ON DELETE CASCADE  ;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle buchung aufgenommen",
        102);
  }

  private void update0103(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchung add abrechnungslauf integer;\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchung add abrechnungslauf integer;\n");

    execute(conn, statements,
        "Spalte abrechnungslauf zur Tabelle buchung hinzugef�gt", 103);
  }

  private void update0104(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung4 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE  DEFERRABLE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung4 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle buchung aufgenommen",
        104);
  }

  private void update0105(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD manuellezahlungen char(5) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD manuellezahlungen char(5) after mitgliedskonto;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte manuellezahlungen in die Tabelle einstellung aufgenommen", 105);
  }

  private void update0106(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungen13 char(5) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungen13 char(5) after manuellezahlungen;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungen13 in die Tabelle einstellung aufgenommen", 106);
  }

  private void update0107(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextabbuchung varchar(100) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextabbuchung varchar(100) after rechnungen13;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungtextabbuchung in die Tabelle einstellung aufgenommen",
        107);
  }

  private void update0108(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextueberweisung varchar(100) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextueberweisung varchar(100) after rechnungtextabbuchung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte rechnungtextueberweisung in die Tabelle einstellung aufgenommen",
        108);
  }

  private void update0109(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextbar varchar(100) before aktuellegeburtstagevorher;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD rechnungtextbar varchar(100) after rechnungtextueberweisung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungtextbar in die Tabelle einstellung aufgenommen", 109);
  }

  private void update0110(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung DROP CONSTRAINT fkBuchung3;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung3 FOREIGN KEY (mitgliedskonto) REFERENCES mitgliedskonto (id);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung DROP FOREIGN KEY fkBuchung3;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung3 FOREIGN KEY (mitgliedskonto) REFERENCES mitgliedskonto (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle buchung erneuert ", 110);
  }

  private void update0111(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchungsart alter column  bezeichnung varchar(50);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchungsart modify column  bezeichnung varchar(50);\n");

    execute(conn, statements,
        "Spalte bezeichnung der Tabelle buchungsart verl�ngert", 111);
  }

  private void update0112(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitgliedfoto (");
    sb.append(" id IDENTITY(1),");
    sb.append(" mitglied INTEGER NOT NULL, ");
    sb.append(" foto BLOB,");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (mitglied), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE mitgliedfoto (");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" mitglied INTEGER NOT NULL, ");
    sb.append(" foto BLOB,");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (mitglied), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mitgliedfoto erstellt", 112);
  }

  private void update0113(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedfoto ADD CONSTRAINT fkMitgliedfoto1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitgliedfoto ADD CONSTRAINT fkMitgliedfoto1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle mitgliedfoto angelegt ",
        113);
  }

  private void update0114(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedfoto char(5) before manuellezahlungen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedfoto char(5) after mitgliedskonto;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte mitgliedfoto in die Tabelle einstellung aufgenommen", 114);
  }

  private void update0115(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaftgruppe ADD pflicht char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaftgruppe ADD pflicht char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte pflicht in die Tabelle eigenschaftgruppe aufgenommen", 115);
  }

  private void update0116(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mail alter column  txt varchar(10000);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mail modify column  txt varchar(10000);\n");

    execute(conn, statements, "Spalte txt der Tabelle mail ge�ndert", 116);
  }

  private void update0117(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mailvorlage alter column  txt varchar(10000);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mailvorlage modify column  txt varchar(10000);\n");

    execute(conn, statements, "Spalte txt der Tabelle mailvorlage ge�ndert",
        117);
  }

  private void update0118(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table konto alter column  bezeichnung varchar(255);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table konto modify column  bezeichnung varchar(255);\n");

    execute(conn, statements, "Spalte bezeichnung der Tabelle konto ge�ngert",
        118);
  }

  private void update0119(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD auslandsadressen char(5) before manuellezahlungen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD auslandsadressen char(5) after mitgliedfoto;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte auslandsadressen in die Tabelle einstellung aufgenommen", 119);
  }

  private void update0120(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD staat varchar(50) before zahlungsweg;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD staat varchar(50) after ort;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte staat in die Tabelle mitglied aufgenommen", 120);
  }

  private void update0121(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD sterbetag date before vermerk1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD sterbetag date after kuendigung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte sterbetag in die Tabelle mitglied aufgenommen", 121);
  }

  private void update0122(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungen13;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungen13;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungen13 aus der Tabelle einstellung entfernt", 122);
  }

  private void update0123(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP manuellezahlungen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP manuellezahlungen;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte manuellezahlungen aus der Tabelle einstellung entfernt", 123);
  }

  private void update0124(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerabbuchung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerabbuchung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungfuerabbuchung aus der Tabelle einstellung entfernt",
        124);
  }

  private void update0125(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerueberweisung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerueberweisung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungfuerueberweisung aus der Tabelle einstellung entfernt",
        125);
  }

  private void update0126(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerbarzahlung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung DROP rechnungfuerbarzahlung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte rechnungfuerbarzahlung aus der Tabelle einstellung entfernt",
        126);
  }

  private void update0127(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("DROP TABLE abrechnung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("DROP TABLE abrechnung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle abrechnung gel�scht", 127);
  }

  private void update0128(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("DROP TABLE manuellerzahlungseingang;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("DROP TABLE manuellerzahlungseingang;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle manuellerzahlungseingang gel�scht", 128);
  }

  private void update0129(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD arbeitseinsatz char(5) before rechnungtextabbuchung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD arbeitseinsatz char(5) after auslandsadressen;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte arbeitseinsatz in die Tabelle einstellung aufgenommen", 129);
  }

  private void update0130(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE beitragsgruppe ADD arbeitseinsatzstunden double;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE beitragsgruppe ADD arbeitseinsatzstunden double;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte arbeitseinsatzstunden in die Tabelle beitragsgruppe aufgenommen",
        130);
  }

  private void update0131(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE beitragsgruppe ADD arbeitseinsatzbetrag double;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE beitragsgruppe ADD arbeitseinsatzbetrag double;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte arbeitseinsatzbetrag in die Tabelle beitragsgruppe aufgenommen",
        131);
  }

  private void update0132(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table arbeitseinsatz (");
    sb.append(" id IDENTITY(1),");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL, ");
    sb.append(" stunden DOUBLE NOT NULL,");
    sb.append(" bemerkung VARCHAR(50), ");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table arbeitseinsatz (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" mitglied INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL,");
    sb.append(" stunden DOUBLE NOT NULL,");
    sb.append(" bemerkung VARCHAR(50), ");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle arbeitseinsatz aufgenommen", 132);
  }

  private void update0133(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table formularfeld alter column  name varchar(30);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table formularfeld modify column  name varchar(30);\n");

    execute(conn, statements,
        "Spalte name der Tabelle formularfeld verl�ngert", 133);
  }

  private void update0134(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaftgruppe ADD max1 char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaftgruppe ADD max1 char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte max1 in die Tabelle eigenschaftgruppe aufgenommen", 134);
  }

  private void update0135(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table buchungdokument (");
    sb.append(" id IDENTITY(1),");
    sb.append(" buchung INTEGER NOT NULL,");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    sb.append("ALTER TABLE buchungdokument ADD CONSTRAINT fkBuchungDokument1 FOREIGN KEY (buchung) REFERENCES buchung (id);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table buchungdokument (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" buchung INTEGER NOT NULL,");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE buchungdokument ADD CONSTRAINT fkBuchungDokument1 FOREIGN KEY (buchung) REFERENCES buchung (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle buchungdokument aufgenommen", 135);
  }

  private void update0136(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("drop table buchungdokument;");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("drop table buchungdokument;");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Tabelle buchungdokument gel�scht", 136);
  }

  private void update0137(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table buchungdokument (");
    sb.append(" id IDENTITY(1),");
    sb.append(" referenz INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL, ");
    sb.append("  bemerkung VARCHAR(50), ");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    sb.append("ALTER TABLE buchungdokument ADD CONSTRAINT fkBuchungDokument1 FOREIGN KEY (referenz) REFERENCES buchung (id);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table buchungdokument (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" referenz INTEGER NOT NULL,");
    sb.append("  datum DATE NOT NULL, ");
    sb.append("  bemerkung VARCHAR(50), ");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE buchungdokument ADD CONSTRAINT fkBuchungDokument1 FOREIGN KEY (referenz) REFERENCES buchung (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle buchungdokument aufgenommen", 137);
  }

  private void update0138(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table mitglieddokument (");
    sb.append(" id IDENTITY(1),");
    sb.append(" referenz INTEGER NOT NULL,");
    sb.append(" datum DATE NOT NULL, ");
    sb.append("  bemerkung VARCHAR(50), ");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    sb.append("ALTER TABLE mitglieddokument ADD CONSTRAINT fkMitgliedDokument1 FOREIGN KEY (referenz) REFERENCES mitglied (id);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table mitglieddokument (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" referenz INTEGER NOT NULL,");
    sb.append("  datum DATE NOT NULL, ");
    sb.append("  bemerkung VARCHAR(50), ");
    sb.append(" uuid VARCHAR(50) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE mitglieddokument ADD CONSTRAINT fkMitgliedDokument1 FOREIGN KEY (referenz) REFERENCES mitglied (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle mitglieddokument aufgenommen", 138);
  }

  private void update0139(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchung add splitid integer;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchung add splitid integer;\n");

    execute(conn, statements, "Spalte splitid zur Tabelle buchung hinzugef�gt",
        139);
  }

  private void update0140(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD dokumentenspeicherung char(5) before rechnungtextabbuchung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD dokumentenspeicherung char(5) after arbeitseinsatz;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte dokumentenspeicherung in die Tabelle einstellung aufgenommen",
        140);
  }

  private void update0141(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD name varchar(30) before geburtsdatumpflicht;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD name varchar(30) first;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte name in die Tabelle einstellung aufgenommen", 141);
  }

  private void update0142(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD blz varchar(8) before geburtsdatumpflicht;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD blz varchar(8) after name;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte blz in die Tabelle einstellung aufgenommen", 142);
  }

  private void update0143(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD konto varchar(10) before geburtsdatumpflicht;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD konto varchar(10) after blz;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte konto in die Tabelle einstellung aufgenommen", 143);
  }

  private void update0144(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD altersgruppen varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD altersgruppen varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte altersgruppen in die Tabelle einstellung aufgenommen", 144);
  }

  private void update0145(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD jubilaeen varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD jubilaeen varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte jubilaeen in die Tabelle einstellung aufgenommen", 145);
  }

  private void update0146(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD altersjubilaeen varchar(50);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD altersjubilaeen varchar(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte altersjubilaeen in die Tabelle einstellung aufgenommen", 146);
  }

  private void update0147(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET name = (SELECT name from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET name = (SELECT name from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte name aus Tabelle stammdaten in Tabelle einstellung kopiert",
        147);
  }

  private void update0148(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET blz = (SELECT blz from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET blz = (SELECT blz from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte blz aus Tabelle stammdaten in Tabelle einstellung kopiert", 148);
  }

  private void update0149(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET konto = (SELECT konto from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET konto = (SELECT konto from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte konto aus Tabelle stammdaten in Tabelle einstellung kopiert",
        149);
  }

  private void update0150(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET altersgruppen = (SELECT altersgruppen from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET altersgruppen = (SELECT altersgruppen from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte altersgruppen aus Tabelle stammdaten in Tabelle einstellung kopiert",
        150);
  }

  private void update0151(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET jubilaeen = (SELECT jubilaeen from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET jubilaeen = (SELECT jubilaeen from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte jubilaeen aus Tabelle stammdaten in Tabelle einstellung kopiert",
        151);
  }

  private void update0152(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET altersjubilaeen = (SELECT altersjubilaeen from stammdaten);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("UPDATE einstellung SET altersjubilaeen = (SELECT altersjubilaeen from stammdaten);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(
        conn,
        statements,
        "Spalte altersjubilaeen aus Tabelle stammdaten in Tabelle einstellung kopiert",
        152);
  }

  private void update0153(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE adresstyp (");
    sb.append("  id IDENTITY(1),");
    sb.append(" bezeichnung varchar(30),");
    sb.append(" jvereinid integer,");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (bezeichnung),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE adresstyp (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung varchar(30),");
    sb.append(" jvereinid integer,");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (bezeichnung),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle adresstyp erstellt", 153);
  }

  private void update0154(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    sb = new StringBuilder();
    sb.append("INSERT into adresstyp VALUES (1, 'Mitglied', 1);\n");
    sb.append("INSERT into adresstyp VALUES (2, 'Spender/in', 2);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Tabelle adresstyp bef�llt", 154);
  }

  private void update0155(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD adresstyp integer default 1 not null before personenart;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD adresstyp integer default 1 not null after externemitgliedsnummer;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte adresstyp in die Tabelle mitglied aufgenommen", 155);
  }

  private void update0156(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    sb = new StringBuilder();
    sb.append("UPDATE mitglied set adresstyp = 1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements,
        "Spalte adresstyp der Tabelle mitglied initial bef�llt", 156);
  }

  private void update0157(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "CREATE INDEX ixMitglied_1 ON mitglied(adresstyp);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "CREATE INDEX ixMitglied_1 ON mitglied(adresstyp);\n");

    execute(conn, statements, "Index f�r Tabelle mitglied erstellt", 157);
  }

  private void update0158(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD CONSTRAINT fkMitglied2 FOREIGN KEY (adresstyp) REFERENCES adresstyp (id);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD CONSTRAINT fkMitglied2 FOREIGN KEY (adresstyp) REFERENCES adresstyp (id);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle mitglied angelegt ", 158);
  }

  private void update0159(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mitglied alter column  adresstyp integer not null;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied modify column  adresstyp integer not null;\n");

    execute(conn, statements,
        "Spalte adresstyp der Tabelle mitglied ver�ndert", 159);
  }

  private void update0160(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD delaytime integer;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD delaytime integer;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte delaytime in die Tabelle einstellung aufgenommen", 160);
  }

  private void update0161(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zusatzadressen char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD zusatzadressen char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte zusatzadressen in die Tabelle einstellung aufgenommen", 161);
  }

  private void update0162(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD letzteaenderung date;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte letzteaenderung in die Tabelle mitglied aufgenommen", 162);
  }

  private void update0163(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mailempfaenger DROP COLUMN adresse;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mailempfaenger DROP COLUMN adresse;\n");

    execute(conn, statements,
        "Spalte adresse aus Tabelle mailempfaenger entfernt", 163);
  }

  private void update0164(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("drop table stammdaten;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("drop table stammdaten;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle stammdaten gel�scht", 164);
  }

  private void update0165(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "alter table buchungsart add spende char(5) ;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte spende zur Tabelle buchungsart hinzugef�gt", 165);
  }

  private void update0166(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "alter table buchung add spendenbescheinigung integer ;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte spendenbescheinigung zur Tabelle buchung hinzugef�gt", 166);
  }

  private void update0167(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "CREATE INDEX ixBuchung1 ON buchung(spendenbescheinigung);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(conn, statements, "Index f�r Tabelle abrechnung erstellt", 167);
  }

  private void update0168(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "ALTER TABLE buchung ADD CONSTRAINT fkBuchung5 FOREIGN KEY (spendenbescheinigung) REFERENCES spendenbescheinigung (id);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Foreign Key f�r Tabelle buchung angelegt ", 168);
  }

  private void update0169(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "alter table spendenbescheinigung add mitglied integer ;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte mitglied zur Tabelle spendenbescheinigung hinzugef�gt", 169);
  }

  private void update0170(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "CREATE INDEX ixSpendenbescheinigung2 ON spendenbescheinigung(mitglied);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(conn, statements,
        "Index f�r Tabelle spendenbescheinigung erstellt", 170);
  }

  private void update0171(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "ALTER TABLE spendenbescheinigung ADD CONSTRAINT fkSpendenbescheinigung2 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Foreign Key f�r Tabelle spendenbescheinigung angelegt ", 171);
  }

  private void update0172(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD strasse char(30) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD strasse char(30) after name;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte strasse in die Tabelle einstellung aufgenommen", 172);
  }

  private void update0173(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD plz char(5) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD plz char(5) after strasse;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte plz in die Tabelle einstellung aufgenommen", 173);
  }

  private void update0174(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD ort char(30) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD ort char(30) after plz;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte ort in die Tabelle einstellung aufgenommen", 174);
  }

  private void update0175(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD finanzamt char(30) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD finanzamt char(30) after ort;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte finanzamt in die Tabelle einstellung aufgenommen", 175);
  }

  private void update0176(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD steuernummer char(30) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD steuernummer char(30) after finanzamt;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte steuernummer in die Tabelle einstellung aufgenommen", 176);
  }

  private void update0177(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD bescheiddatum date before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD bescheiddatum date after steuernummer;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte bescheiddatum die Tabelle einstellung aufgenommen", 177);
  }

  private void update0178(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD vorlaeufig char(5) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD vorlaeufig char(5) after bescheiddatum;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte vorlaeufig in die Tabelle einstellung aufgenommen", 178);
  }

  private void update0179(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD beguenstigterzweck char(30) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD beguenstigterzweck char(30) after vorlaeufig;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte beguenstigterzweck in die Tabelle einstellung aufgenommen", 179);
  }

  private void update0180(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedsbeitraege char(5) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD mitgliedsbeitraege char(5) after beguenstigterzweck;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte mitgliedsbeitraege in die Tabelle einstellung aufgenommen", 180);
  }

  private void update0181(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD vorlaeufigab date before beguenstigterzweck;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD vorlaeufigab date after vorlaeufig;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte vorlaeufigab die Tabelle einstellung aufgenommen", 181);
  }

  private void update0182(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE spendenbescheinigung ADD spendenart int default 1 not null before zeile1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE spendenbescheinigung ADD spendenart int default 1 not null after id;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte vorlaeufigab die Tabelle spendenbescheinigung aufgenommen", 182);
  }

  private void update0183(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "ALTER TABLE spendenbescheinigung ADD bezeichnungsachzuwendung varchar(100);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(
        conn,
        statements,
        "Spalte bezeichnungssachzuwendung in die Tabelle spendenbescheinigung aufgenommen",
        183);
  }

  private void update0184(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "ALTER TABLE spendenbescheinigung ADD herkunftspende int;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(
        conn,
        statements,
        "Spalte herkunftspende in die Tabelle spendenbescheinigung aufgenommen",
        184);
  }

  private void update0185(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "ALTER TABLE spendenbescheinigung ADD unterlagenwertermittlung char(5);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(
        conn,
        statements,
        "Spalte unterlagenwertermittlung in die Tabelle spendenbescheinigung aufgenommen",
        185);
  }

  private void update0186(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung DROP COLUMN aktuellegeburtstagevorher;\n"
                + "ALTER TABLE einstellung DROP COLUMN aktuellegeburtstagenachher;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN aktuellegeburtstagevorher, "
            + "DROP COLUMN aktuellegeburtstagenachher;\n");

    execute(conn, statements, "Spalten aus Tabelle einstellung entfernt", 186);
  }

  private void update0187(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), "-- nothing to do;\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE `mail`  DROP INDEX `betreff`;\n");

    execute(conn, statements, "Index von mail entfernt (nur MySQL)", 187);
  }

  private void update0188(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "ALTER TABLE beitragsgruppe ADD buchungsart integer;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);
    execute(conn, statements,
        "Spalte buchungsart in die Tabelle beitragsgruppe aufgenommen", 188);
  }

  private void update0189(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "ALTER TABLE beitragsgruppe ADD CONSTRAINT fkBeitragsgruppe1 FOREIGN KEY (buchungsart) REFERENCES buchungsart(id);\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Foreign Key f�r Tabelle beitragsgruppe angelegt ", 189);
  }

  private void update0190(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_starttls char(5);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_starttls char(5);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_startls in die Tabelle einstellung aufgenommen", 190);
  }

  private void update0191(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE formularfeld ALTER COLUMN name varchar(60);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE formularfeld MODIFY COLUMN name varchar(60);\n");

    execute(conn, statements,
        "Spalte name in der Tabelle formularfeld ge�ndert", 191);
  }

  private void update0192(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "UPDATE formularfeld set name = replace(name,'.','_');\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Umsetzung Formularfeldnamen", 192);
  }

  private void update0193(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE auswertung (");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(30) NOT NULL,");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE auswertung (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(30) NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle auswertung aufgenommen", 193);
  }

  private void update0194(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE auswertungpos (");
    sb.append(" id IDENTITY(1),");
    sb.append(" auswertung integer not null, ");
    sb.append(" feld VARCHAR(50) NOT NULL, ");
    sb.append(" zeichenfolge VARCHAR(100) ,");
    sb.append(" datum DATE, ");
    sb.append(" ganzzahl integer, ");
    sb.append(" janein char(5), ");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE auswertungpos (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" auswertung integer not null, ");
    sb.append(" feld VARCHAR(50) NOT NULL, ");
    sb.append(" zeichenfolge VARCHAR(100) ,");
    sb.append(" datum DATE, ");
    sb.append(" ganzzahl integer, ");
    sb.append(" janein char(5), ");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle auswertungpos aufgenommen", 194);
  }

  private void update0195(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE auswertungpos ADD CONSTRAINT fkAuswertungpos1 FOREIGN KEY (auswertung) REFERENCES auswertung (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE auswertungpos ADD CONSTRAINT fkAuswertungpos1 FOREIGN KEY (auswertung) REFERENCES auswertung (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Foreign Key f�r Tabelle  auswertungpos aufgenommen", 195);
  }

  private void update0196(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();

    String sql = "drop table auswertungpos\n;" + "drop table auswertung;\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Foreign Key f�r Tabelle  auswertungstabellen gel�scht", 196);
  }

  private void update0197(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD individuellebeitraege char(5) before rechnungtextabbuchung;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD individuellebeitraege char(5) after dokumentenspeicherung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte individuellebeitraege in die Tabelle lehrgangsart aufgenommen",
        197);
  }

  private void update0198(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE mitglied ADD individuellerbeitrag DOUBLE before zahlerid;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE mitglied ADD individuellerbeitrag DOUBLE after beitragsgruppe;\n");

    execute(conn, statements,
        "Spalte individuellerBeitrag in die Tabelle mitglied eingef�gt", 198);
  }

  private void update0199(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE zusatzabbuchung ADD buchungstext2 VARCHAR(27) before betrag;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE zusatzabbuchung ADD buchungstext2 VARCHAR(27) after buchungstext;\n");

    execute(conn, statements,
        "Spalte buchungstext2 in die Tabelle zusatzabbuchung eingef�gt", 199);
  }

  private void update0200(Connection conn) throws ApplicationException
  {
    final String ID = "ID";

    final String EXTERNEMITGLIEDSNUMMER = "externe Mitgliedsnummer";

    final String ANREDE = "Anrede";
    final String TITEL = "Titel";

    final String NAME = "Name";

    final String VORNAME = "Vorname";

    final String ADRESSIERUNGSZUSATZ = "Adressierungszusatz";
    final String STRASSE = "Strasse";

    final String PLZ = "PLZ";

    final String ORT = "Ort";

    final String STAAT = "Staat";

    final String ZAHLUNGSRHYTMUS = "Zahlungsrhytmus";

    final String BLZ = "Bankleitzahl";

    final String KONTO = "Konto";

    final String KONTOINHABER = "Kontoinhaber";

    final String GEBURTSDATUM = "Geburtsdatum";

    final String GESCHLECHT = "Geschlecht";

    final String TELEFONPRIVAT = "Telefon privat";

    final String TELEFONDIENSTLICH = "Telefon dienstlich";

    final String HANDY = "Handy";

    final String EMAIL = "Email";

    final String EINTRITT = "Eintritt";

    final String BEITRAGSGRUPPE = "Beitragsgruppe";

    final String AUSTRITT = "Austritt";

    final String ZAHLUNGSGRUND = "Zahlungsgrund";

    final String ZAHLUNGSGRUND1 = "Zahlungsgrund 1";

    final String ZAHLUNGSGRUND2 = "Zahlungsgrund 2";

    final String BUCHUNGSDATUM = "Buchungsdatum";

    final String ZAHLUNGSWEG = "Zahlungsweg";

    final String BETRAG = "Betrag";

    final String KUENDIGUNG = "K�ndigung";
    final String sql1 = "UPDATE formularfeld SET name = '";
    final String sql2 = "' WHERE name = '";
    final String sql3 = "';\n";
    String sql = sql1
        + MitgliedVar.ID.getName()
        + sql2
        + ID
        + sql3 //
        + sql1
        + MitgliedVar.EXTERNE_MITGLIEDSNUMMER.getName()
        + sql2
        + EXTERNEMITGLIEDSNUMMER
        + sql3 //
        + sql1
        + MitgliedVar.ANREDE.getName()
        + sql2
        + ANREDE
        + sql3 //
        + sql1
        + MitgliedVar.TITEL.getName()
        + sql2
        + TITEL
        + sql3 //
        + sql1
        + MitgliedVar.NAME.getName()
        + sql2
        + NAME
        + sql3 //
        + sql1
        + MitgliedVar.VORNAME.getName()
        + sql2
        + VORNAME
        + sql3 //
        + sql1
        + MitgliedVar.ADRESSIERUNGSZUSATZ.getName()
        + sql2
        + ADRESSIERUNGSZUSATZ
        + sql3 //
        + sql1
        + MitgliedVar.STRASSE.getName()
        + sql2
        + STRASSE
        + sql3 //
        + sql1
        + MitgliedVar.PLZ.getName()
        + sql2
        + PLZ
        + sql3 //
        + sql1
        + MitgliedVar.ORT.getName()
        + sql2
        + ORT
        + sql3 //
        + sql1
        + MitgliedVar.STAAT.getName()
        + sql2
        + STAAT
        + sql3 //
        + sql1
        + MitgliedVar.ZAHLUNGSRHYTMUS.getName()
        + sql2
        + ZAHLUNGSRHYTMUS
        + sql3 //
        + sql1
        + MitgliedVar.ZAHLUNGSWEG.getName()
        + sql2
        + ZAHLUNGSWEG
        + sql3 //
        + sql1
        + MitgliedVar.BLZ.getName()
        + sql2
        + BLZ
        + sql3 //
        + sql1
        + MitgliedVar.KONTO.getName()
        + sql2
        + KONTO
        + sql3 //
        + sql1
        + MitgliedVar.KONTOINHABER.getName()
        + sql2
        + KONTOINHABER
        + sql3 //
        + sql1
        + MitgliedVar.GEBURTSDATUM.getName()
        + sql2
        + GEBURTSDATUM
        + sql3 //
        + sql1
        + MitgliedVar.GESCHLECHT.getName()
        + sql2
        + GESCHLECHT
        + sql3 //
        + sql1
        + MitgliedVar.TELEFONDIENSTLICH.getName()
        + sql2
        + TELEFONDIENSTLICH
        + sql3 //
        + sql1
        + MitgliedVar.TELEFONPRIVAT.getName()
        + sql2
        + TELEFONPRIVAT
        + sql3 //
        + sql1
        + MitgliedVar.HANDY.getName()
        + sql2
        + HANDY
        + sql3 //
        + sql1
        + MitgliedVar.EMAIL.getName()
        + sql2
        + EMAIL
        + sql3 //
        + sql1
        + MitgliedVar.EINTRITT.getName()
        + sql2
        + EINTRITT
        + sql3 //
        + sql1
        + MitgliedVar.AUSTRITT.getName()
        + sql2
        + AUSTRITT
        + sql3 //
        + sql1
        + MitgliedVar.KUENDIGUNG.getName()
        + sql2
        + KUENDIGUNG
        + sql3 //
        + sql1
        + MitgliedVar.KUENDIGUNG.getName()
        + sql2
        + KUENDIGUNG
        + sql3 //
        + sql1
        + MitgliedVar.BEITRAGSGRUPPE_BEZEICHNUNG.getName()
        + sql2
        + BEITRAGSGRUPPE
        + sql3 //
        + sql1
        + MitgliedskontoVar.ZAHLUNGSGRUND.getName()
        + sql2
        + ZAHLUNGSGRUND
        + sql3//
        + sql1 + MitgliedskontoVar.ZAHLUNGSGRUND1.getName()
        + sql2
        + ZAHLUNGSGRUND1
        + sql3//
        + sql1 + MitgliedskontoVar.ZAHLUNGSGRUND2.getName() + sql2
        + ZAHLUNGSGRUND2
        + sql3//
        + sql1 + MitgliedskontoVar.BUCHUNGSDATUM.getName() + sql2
        + BUCHUNGSDATUM + sql3//
        + sql1 + "tagesdatum" + sql2 + "Tagesdatum" + sql3//
        + sql1 + MitgliedskontoVar.BETRAG.getName() + sql2 + BETRAG + sql3//
    ;
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Tabelle formularfeld an aktualisiert", 200);
  }

  private void update0201(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "delete from arbeitseinsatz where (select count(*) from mitglied where mitglied.id = arbeitseinsatz.mitglied) = 0";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Arbeitseins�tze ohne Mitglied gel�scht", 201);
  }

  private void update0202(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE arbeitseinsatz ADD CONSTRAINT fkArbeitseinsatz1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE arbeitseinsatz ADD CONSTRAINT fkArbeitseinsatz1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");

    execute(conn, statements,
        "Foreign Key f�r Tabelle arbeitseinsatz erstellt", 202);
  }

  private void update0203(Connection conn) throws ApplicationException
  {
    ArrayList<BooleanUpdate> bu = new ArrayList<JVereinUpdateProvider.BooleanUpdate>();
    bu.add(new BooleanUpdate("einstellung", "vorlaeufig"));
    bu.add(new BooleanUpdate("einstellung", "geburtsdatumpflicht"));
    bu.add(new BooleanUpdate("einstellung", "eintrittsdatumpflicht"));
    bu.add(new BooleanUpdate("einstellung", "kommunikationsdaten"));
    bu.add(new BooleanUpdate("einstellung", "zusatzabbuchung"));
    bu.add(new BooleanUpdate("einstellung", "vermerke"));
    bu.add(new BooleanUpdate("einstellung", "wiedervorlage"));
    bu.add(new BooleanUpdate("einstellung", "kursteilnehmer"));
    bu.add(new BooleanUpdate("einstellung", "mitgliedsbeitraege"));
    bu.add(new BooleanUpdate("einstellung", "lehrgaenge"));
    bu.add(new BooleanUpdate("einstellung", "juristischepersonen"));
    bu.add(new BooleanUpdate("einstellung", "mitgliedskonto"));
    bu.add(new BooleanUpdate("einstellung", "mitgliedfoto"));
    bu.add(new BooleanUpdate("einstellung", "zusatzadressen"));
    bu.add(new BooleanUpdate("einstellung", "auslandsadressen"));
    bu.add(new BooleanUpdate("einstellung", "arbeitseinsatz"));
    bu.add(new BooleanUpdate("einstellung", "dokumentenspeicherung"));
    bu.add(new BooleanUpdate("einstellung", "individuellebeitraege"));
    bu.add(new BooleanUpdate("einstellung", "externemitgliedsnummer"));
    bu.add(new BooleanUpdate("einstellung", "smtp_ssl"));
    bu.add(new BooleanUpdate("einstellung", "smtp_starttls"));
    bu.add(new BooleanUpdate("eigenschaftgruppe", "pflicht"));
    bu.add(new BooleanUpdate("eigenschaftgruppe", "max1"));
    bu.add(new BooleanUpdate("abrechnungslauf", "zusatzbetraege"));
    bu.add(new BooleanUpdate("abrechnungslauf", "kursteilnehmer"));
    bu.add(new BooleanUpdate("abrechnungslauf", "dtausdruck"));
    bu.add(new BooleanUpdate("buchungsart", "spende"));
    bu.add(new BooleanUpdate("spendenbescheinigung", "ersatzaufwendungen"));
    bu.add(new BooleanUpdate("spendenbescheinigung", "unterlagenwertermittlung"));
    bu.add(new BooleanUpdate("zusatzfelder", "feldjanein"));

    for (BooleanUpdate b : bu)
    {
      // H2
      Map<String, String[]> statements = new HashMap<String, String[]>();
      statements.put(
          DBSupportH2Impl.class.getName(),
          new String[] { "ALTER TABLE " + b.getTabelle() + " ALTER COLUMN "
              + b.getSpalte() + " BOOLEAN;\n" });
      execute(conn, statements, "Boolean-Spalten angepasst", 203, true);
      // MySQL
      statements = new HashMap<String, String[]>();
      statements.put(
          DBSupportMySqlImpl.class.getName(),
          new String[] {
              "ALTER TABLE `" + b.getTabelle() + "` ADD COLUMN `"
                  + b.getSpalte() + "_b` BIT(1) AFTER `" + b.getSpalte()
                  + "`;\n",
              "UPDATE `" + b.getTabelle() + "` SET `" + b.getSpalte()
                  + "_b` = false;\n",
              "UPDATE `" + b.getTabelle() + "` SET `" + b.getSpalte()
                  + "_b` = true WHERE TRIM(`" + b.getSpalte()
                  + "`) = 'TRUE';\n",
              "ALTER TABLE `" + b.getTabelle() + "` DROP COLUMN `"
                  + b.getSpalte() + "`;\n",
              "ALTER TABLE `" + b.getTabelle() + "` CHANGE COLUMN `"
                  + b.getSpalte() + "_b` `" + b.getSpalte() + "` BIT(1);\n" });
      execute(conn, statements, "Boolean-Spalten angepasst", 203, true);
    }
  }

  public class BooleanUpdate
  {

    private String tabelle;

    private String spalte;

    public BooleanUpdate(String tabelle, String spalte)
    {
      this.tabelle = tabelle;
      this.spalte = spalte;
    }

    public String getTabelle()
    {
      return tabelle;
    }

    public String getSpalte()
    {
      return spalte;
    }
  }

  private void update0204(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "delete from eigenschaften where (select count(*) from eigenschaft where eigenschaft.id = eigenschaften.eigenschaft) = 0;";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Ggfls. Bugfix f. gel�schte Eigenschaften", 204);
  }

  private void update0205(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften2 FOREIGN KEY (eigenschaft) REFERENCES eigenschaft (id) ON DELETE CASCADE;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften2 FOREIGN KEY (eigenschaft) REFERENCES eigenschaft (id) ON DELETE CASCADE;\n");

    execute(conn, statements, "Foreign Key f�r Tabelle eigenschaften erstellt",
        205);
  }

  private void update0206(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD sterbedatum boolean before kommunikationsdaten;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD sterbedatum bit(1) after eintrittsdatumpflicht;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte sterbedatum in die Tabelle einstellung aufgenommen", 206);
  }

  private void update0207(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE abrechnungslauf SET modus = 1 where modus >=2 and modus <=4;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Modus modifiziert in Tabelle abrechnungslauf",
        207);
  }

  private void update0208(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE einstellung SET beitragsmodel = 1 where beitragsmodel >=2 and beitragsmodel <=4;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Beitragsmodel modifiziert in Tabelle einstellung", 208);
  }

  private void update0209(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD dtaustextschluessel char(2) before altersgruppen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD dtaustextschluessel char(2) after zahlungsrhytmus;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte dtaustextschluessel in die Tabelle einstellung aufgenommen",
        209);
  }

  private void update0210(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "UPDATE einstellung SET dtaustextschluessel = '05' WHERE dtaustextschluessel IS NULL";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte dtaustextschluessel in der Tabelle einstellung initialisiert",
        210);
  }

  private void update0211(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();

    String sql = "ALTER TABLE buchung ADD verzicht BOOLEAN";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte verzicht in der Tabelle buchung aufgenommen", 211);
  }

  private void update0212(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();

    String sql = "ALTER TABLE spendenbescheinigung ADD autocreate BOOLEAN default false";
    statements.put(DBSupportH2Impl.class.getName(), sql);
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte autocreate in der Tabelle spendenbescheinigung aufgenommen",
        212);
  }

  private void update0213(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung ADD namelang VARCHAR(100) before strasse;\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung ADD namelang VARCHAR(100) after name;\n");
    execute(conn, statements,
        "Spalte NameLang in die Tabelle Einstellung aufgenommen", 213);
  }

  private void update0214(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD dateinamenmusterspende VARCHAR(50) before beginngeschaeftsjahr;\n");
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD dateinamenmusterspende VARCHAR(50) after dateinamenmuster;\n");
    execute(conn, statements,
        "Spalte dateinamenmusterspende in die Tabelle einstellung aufgenommen",
        214);
  }

  private void update0215(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungminbetrag DOUBLE before beginngeschaeftsjahr;\n");
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungminbetrag DOUBLE after dateinamenmusterspende;\n");
    execute(
        conn,
        statements,
        "Spalte spendenbescheinigungminbetrag in die Tabelle einstellung aufgenommen",
        215);
  }

  private void update0216(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungverzeichnis VARCHAR(200) before beginngeschaeftsjahr;\n");
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungverzeichnis VARCHAR(200) after spendenbescheinigungminbetrag;\n");
    execute(
        conn,
        statements,
        "Spalte spendenbescheinigungverzeichnis in die Tabelle einstellung aufgenommen",
        216);
  }

  private void update0217(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungprintbuchungsart BOOLEAN DEFAULT FALSE before beginngeschaeftsjahr;\n");
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD spendenbescheinigungprintbuchungsart BOOLEAN DEFAULT FALSE after spendenbescheinigungverzeichnis;\n");
    execute(
        conn,
        statements,
        "Spalte spendenbescheinigungprintbuchungsart in die Tabelle einstellung aufgenommen",
        217);
  }

  private void update0218(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung ALTER COLUMN strasse VARCHAR(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung MODIFY COLUMN strasse VARCHAR(50);\n");
    execute(conn, statements,
        "Spalte strasse in der Tabelle einstellung verl�ngert", 218);
  }

  private void update0219(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung ALTER COLUMN ort VARCHAR(50);\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung MODIFY COLUMN ort VARCHAR(50);\n");
    execute(conn, statements,
        "Spalte ort in der Tabelle einstellung verl�ngert", 219);
  }

  private void update0220(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ALTER COLUMN beguenstigterzweck VARCHAR(100);\n");
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung MODIFY COLUMN beguenstigterzweck VARCHAR(100);\n");
    execute(conn, statements,
        "Spalte beguenstigterzweck in der Tabelle einstellung verl�ngert", 220);
  }

  private void update0221(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE formularfeld ADD seite INTEGER DEFAULT 1 before x;\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE formularfeld ADD Seite INTEGER DEFAULT 1 after name;\n");
    execute(conn, statements,
        "Spalte seite in die Tabelle formularfeld aufgenommen", 221);
  }

  private void update0222(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "UPDATE einstellung SET namelang = name;\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "UPDATE einstellung SET namelang = name;\n");
    execute(conn, statements,
        "Defaultwert f�r namelang in der Tabelle einstellung gesetzt", 222);
  }

  private void update0223(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "UPDATE einstellung SET spendenbescheinigungminbetrag = 0;\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "UPDATE einstellung SET spendenbescheinigungminbetrag = 0;\n");
    execute(conn, statements,
        "Defaultwert f�r Spalte spendenbescheinigungminbetrag gesetzt", 223);
  }

  private void update0224(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(),
        "UPDATE formularfeld SET seite = 1;\n");
    statements.put(DBSupportMySqlImpl.class.getName(),
        "UPDATE formularfeld SET seite = 1;\n");
    execute(conn, statements,
        "Defaultwert f�r Spalte seite in der Tabelle formularfeld gesetzt", 224);
  }

  private void update0225(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE lesefeld (");
    sb.append("  id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" script VARCHAR(1000),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE lesefeld (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" script VARCHAR(1000),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(" )  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle lesefeld erstellt", 225);
  }

  private void update0226(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("-- nothing do to");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE formularfeld ");
    sb.append("  CHANGE COLUMN `Seite` `seite` INT(10) NULL;");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Spaltenname Seite in seite ge�ndert", 226);
  }

  private void update0227(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("create table projekt (");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(");\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("create table projekt (");
    sb.append(" id INTEGER AUTO_INCREMENT,");
    sb.append(" bezeichnung VARCHAR(50),");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle projekt aufgenommen", 227);
  }

  private void update0228(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table buchung add projekt integer;\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table buchung add projekt integer;\n");

    execute(conn, statements, "Spalte projekt zur Tabelle buchung hinzugef�gt",
        228);
  }

  private void update0229(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung6 FOREIGN KEY (projekt) REFERENCES projekt (id) ;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE buchung ADD CONSTRAINT fkBuchung6 FOREIGN KEY (projekt) REFERENCES projekt (id) ;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key f�r Tabelle buchung aufgenommen",
        229);
  }

  private void update0230(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE formularfeld ALTER COLUMN font varchar(50);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE formularfeld MODIFY COLUMN font varchar(50);\n");

    execute(conn, statements,
        "Spalte font in der Tabelle formularfeld verl�ngert", 230);
  }

  private void update0231(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE zusatzbetragabrechnungslauf(");
    sb.append(" id IDENTITY(1),");
    sb.append(" abrechnungslauf integer not null,");
    sb.append(" zusatzbetrag integer not null,");
    sb.append(" letzteausfuehrung date, ");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    sb.append("ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    sb.append("ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf2 FOREIGN KEY (zusatzbetrag) REFERENCES zusatzabbuchung (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE zusatzbetragabrechnungslauf(");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" abrechnungslauf integer not null,");
    sb.append(" zusatzbetrag integer not null,");
    sb.append(" letzteausfuehrung date, ");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    sb.append("ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    sb.append("ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf2 FOREIGN KEY (zusatzbetrag) REFERENCES zusatzabbuchung (id) ON DELETE CASCADE ON UPDATE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle zusatzbetragabrechnungslauf", 231);
  }

  private void update0232(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD uselesefelder char(5) before auslandsadressen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD uselesefelder char(5) after mitgliedfoto;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte uselesefelder in die Tabelle einstellung aufgenommen", 232);
  }

  private void update0233(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD versand TIMESTAMP;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD versand TIMESTAMP;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte versand in die Tabelle mailempfaenger aufgenommen", 233);
  }

  private void update0234(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE buchung ALTER COLUMN zweck varchar(500);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE buchung MODIFY COLUMN zweck varchar(500);\n");

    execute(conn, statements, "Spalte zweck in der Tabelle buchung verl�ngert",
        234);
  }

  private void update0235(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "update buchung set zweck = concat(zweck, char(13), char(10), zweck2) where zweck2 is not null and length(zweck2) >0;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte zweck und zweck2 in der Tabelle buchung vereinigt", 235);
  }

  private void update0236(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE buchung DROP COLUMN zweck2;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE buchung DROP COLUMN zweck2;\n");

    execute(conn, statements, "Spalte zweck2 aus Tabelle buchung entfernt", 236);
  }

  private void update0237(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitgliedskonto ALTER COLUMN zweck1 varchar(500);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitgliedskonto MODIFY COLUMN zweck1 varchar(500);\n");

    execute(conn, statements,
        "Spalte zweck1 in der Tabelle mitgliedskonto verl�ngert", 237);
  }

  private void update0238(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "update mitgliedskonto set zweck1 = concat(zweck1, char(13), char(10), zweck2) where zweck2 is not null and length(zweck2) >0;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte zweck1 und zweck2 in der Tabelle mitgliedskonto vereinigt", 238);
  }

  private void update0239(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitgliedskonto DROP COLUMN zweck2;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitgliedskonto DROP COLUMN zweck2;\n");

    execute(conn, statements,
        "Spalte zweck2 aus Tabelle mitgliedskonto entfernt", 239);
  }

  private void update0240(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "update formularfeld set name = replace(name, '.','_');\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "update formularfeld set name = replace(name, '.','_');\n");

    execute(conn, statements, "Formularfeld-Namen angepasst", 240);
  }

  private void update0241(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD defaultland char(2) before altersgruppen;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD defaultland char(2) after dtaustextschluessel;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte defaultland in die Tabelle einstellung aufgenommen", 241);
  }

  private void update0242(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger DROP CONSTRAINT FKMAILEMPFAENGER2;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger DROP FOREIGN KEY fkMailEmpfaenger2;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Foreign Key aus Tabelle mailempfaenger entfernt", 242);
  }

  private void update0243(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailempfaenger2 FOREIGN KEY (mitglied) REFERENCES mitglied (id)  ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailempfaenger2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 2 f�r mailempfaenger neu erstellt",
        243);
  }

  private void update0244(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("DROP INDEX IXEIGENSCHAFT1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE eigenschaft DROP INDEX ixEigenschaft1;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Index aus Tabelle eigenschaft entfernt", 244);
  }

  private void update0245(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "CREATE UNIQUE INDEX ixEigenschaft1 ON eigenschaft(bezeichnung, eigenschaftgruppe);\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "CREATE UNIQUE INDEX ixEigenschaft1 ON eigenschaft(bezeichnung, eigenschaftgruppe);\n");

    execute(conn, statements, "Index f�r Tabelle eigenschaft erstellt", 245);
  }

  private void update0246(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD bic varchar(11) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD bic varchar(11) after mitgliedsbeitraege;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte bic in die Tabelle einstellung aufgenommen", 246);
  }

  private void update0247(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD iban varchar(22) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD iban varchar(22) after bic;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte iban in die Tabelle einstellung aufgenommen", 247);
  }

  private void update0248(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD glaeubigerid varchar(35) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD glaeubigerid varchar(35) after iban;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte glaeubigerid in die Tabelle einstellung aufgenommen", 248);
  }

  private void update0249(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_from_anzeigename varchar(50) before smtp_ssl;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE einstellung ADD smtp_from_anzeigename varchar(50) after smtp_from_address;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte smtp_from_anzeigename in die Tabelle einstellung aufgenommen",
        249);
  }

  private void update0250(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD bic varchar(11) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD bic varchar(11) after zahlungsrhytmus;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Spalte bic in die Tabelle mitglied aufgenommen",
        250);
  }

  private void update0251(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD iban varchar(22) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied ADD iban varchar(22) after bic;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte iban in die Tabelle mitglied aufgenommen", 251);
  }

  private void update0252(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE bank(");
    sb.append(" id IDENTITY(1),");
    sb.append(" bezeichnung varchar(27) not null,");
    sb.append(" blz varchar(8) not null,");
    sb.append(" bic varchar(11) not null, ");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (blz),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE bank(");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" bezeichnung varchar(27) not null,");
    sb.append(" blz varchar(8) not null,");
    sb.append(" bic varchar(11) not null, ");
    sb.append(" UNIQUE (id),");
    sb.append(" UNIQUE (blz),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle bank erstellt", 252);
  }

  private void update0253(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE INDEX IXBANK1 ON bank (bic)");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    // statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, "Index in Tabelle bank erstellt", 253);
  }

  private void update0254(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();

    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 254);
  }

  private void update0255(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE sepaparam(");
    sb.append(" id CHAR(3),");
    sb.append(" bezeichnung varchar(20) not null,");
    sb.append(" bankidentifierlength integer not null,");
    sb.append(" accountlength integer not null,");
    sb.append(" bankidentifiersample varchar(20) not null,");
    sb.append(" accountsample varchar(20) not null,");
    sb.append(" ibansample varchar(33) not null,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE sepaparam(");
    sb.append(" id CHAR(3), ");
    sb.append(" bezeichnung varchar(20) not null,");
    sb.append(" bankidentifierlength integer not null,");
    sb.append(" accountlength integer not null,");
    sb.append(" bankidentifiersample varchar(20) not null,");
    sb.append(" accountsample varchar(20) not null,");
    sb.append(" ibansample varchar(33) not null,");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle sepaparam erstellt", 255);
  }

  private void update0256(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 256);
  }

  private void update0257(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 257);
  }

  private void update0258(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 258);
  }

  private void update0259(Connection conn) throws ApplicationException
  {
    final String sqlUpdateH2 = "ALTER TABLE einstellung ADD jubilarstartalter INTEGER before jubilaeen;\n";
    final String sqlUpdateMySql = "ALTER TABLE einstellung ADD jubilarstartalter INTEGER after jubilaeen;\n";

    Map<String, String> statements = new HashMap<String, String>();
    statements.put(DBSupportH2Impl.class.getName(), sqlUpdateH2);
    statements.put(DBSupportMySqlImpl.class.getName(), sqlUpdateMySql);
    execute(conn, statements,
        "Spalte jubilarstartalter in die Tabelle einstellung aufgenommen", 259);
  }

  private void update0260(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD bic varchar(11) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD bic varchar(11) after name;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte bic in die Tabelle kursteilnehmer aufgenommen", 260);
  }

  private void update0261(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD iban varchar(22) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD iban varchar(22) after bic;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte iban in die Tabelle kursteilnehmer aufgenommen", 261);
  }

  private void update0262(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table einstellung alter column konto varchar(12);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table einstellung modify column  konto varchar(12);\n");

    execute(conn, statements,
        "Spalte konto der Tabelle einstellung verl�ngert", 262);
  }

  private void update0263(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mitglied alter column konto varchar(12);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied modify column  konto varchar(12);\n");

    execute(conn, statements, "Spalte konto der Tabelle mitglied verl�ngert",
        263);
  }

  private void update0264(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table kursteilnehmer alter column konto varchar(12);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer modify column  konto varchar(12);\n");

    execute(conn, statements,
        "Spalte konto der Tabelle kursteilnehmer verl�ngert", 264);
  }

  private void update0265(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table anfangsbestand alter column konto varchar(12);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer modify column  konto varchar(12);\n");

    execute(conn, statements,
        "Spalte anfangsbestand der Tabelle kursteilnehmer verl�ngert", 265);
  }

  private void update0266(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE bank ADD land varchar(2) before blz;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE bank ADD land varchar(2) after bezeichnung;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Spalte land in die Tabelle bank aufgenommen",
        266);
  }

  private void update0267(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 267);
  }

  private void update0268(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 268);
  }

  private void update0269(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE adresstyp ADD bezeichnungplural varchar(30) before jvereinid;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE adresstyp ADD bezeichnungplural varchar(30) after bezeichnung;\n");

    execute(conn, statements,
        "Spalte bezeichnungplural in die Tabelle adresstyp eingef�gt", 269);
  }

  private void update0270(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE adresstyp SET bezeichnungplural = bezeichnung;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte bezeichnungplural gef�llt", 270);
  }

  private void update0271(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE adresstyp SET bezeichnungplural = 'Mitglieder' WHERE jvereinid=1;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte bezeichnungplural gef�llt", 271);
  }

  private void update0272(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE adresstyp SET bezeichnungplural = 'Spender/innen' WHERE jvereinid=2;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte bezeichnungplural gef�llt", 272);
  }

  private void update0273(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 274);
  }

  private void update0274(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2 + MySQL
    sb = new StringBuilder();
    sb.append("-- Nothing to do");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements, " ", 274);
  }

  private void update0275(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mitglied alter column konto varchar(16);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied modify column  konto varchar(16);\n");

    execute(conn, statements, "Spalte konto der Tabelle mitglied verl�ngert",
        275);
  }

  private void update0276(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table einstellung alter column iban varchar(34);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table einstellung modify column  iban varchar(34);\n");

    execute(conn, statements, "Spalte iban der Tabelle einstellung verl�ngert",
        276);
  }

  private void update0277(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mitglied alter column iban varchar(34);\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied modify column  iban varchar(34);\n");
    execute(conn, statements, "Spalte iban der Tabelle mitglied verl�ngert",
        277);
  }

  private void update0278(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table kursteilnehmer alter column iban varchar(34);\n");
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer modify column  iban varchar(34);\n");
    execute(conn, statements,
        "Spalte iban der Tabelle kursteilnehmer verl�ngert", 278);
  }

  //

  private void update0279(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("alter table spendenbescheinigung alter column zeile1 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile2 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile3 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile4 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile5 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile6 varchar(80);\n");
    sb.append("alter table spendenbescheinigung alter column zeile7 varchar(80);\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());
    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("alter table spendenbescheinigung modify column zeile1 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile2 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile3 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile4 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile5 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile6 varchar(80);\n");
    sb.append("alter table spendenbescheinigung modify column zeile7 varchar(80);\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());
    execute(conn, statements,
        "Spalte ZeileX der Tabelle spendenbescheinigung verl�ngert", 279);
  }

  private void update0280(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table mitglied add mandatdatum date before bic;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied add mandatdatum date after zahlungsrhytmus;\n");

    execute(conn, statements,
        "Spalte mandatdatum zur Tabelle mitglied hinzugef�gt", 280);
  }

  private void update0281(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    String sql = "UPDATE mitglied set mandatdatum = eintritt where zahlungsweg = "
        + Zahlungsweg.BASISLASTSCHRIFT + ";\n";
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte mandatdatum mit eintrittsdatum belegt",
        281);
  }

  private void update0282(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table kursteilnehmer add mandatdatum date before bic;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer add mandatdatum date after vzweck2;\n");

    execute(conn, statements,
        "Spalte mandatdatum zur Tabelle kursteilnehmer hinzugef�gt", 282);
  }

  private void update0283(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN mitgliedskonto;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN mitgliedskonto;\n");

    execute(conn, statements, "Spalten aus Tabelle einstellung entfernt", 283);
  }

  private void update0284(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN dtaustextschluessel;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN dtaustextschluessel;\n");

    execute(conn, statements, "Spalten aus Tabelle einstellung entfernt", 284);
  }

  private void update0285(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD strasse varchar(40) before vzweck1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD strasse varchar(40) after name;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte strasse in die Tabelle kursteilnehmer aufgenommen", 285);
  }

  private void update0286(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD plz varchar(10) before vzweck1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD plz varchar(10) after strasse;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte plz in die Tabelle kursteilnehmer aufgenommen", 286);
  }

  private void update0287(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD ort varchar(40) before vzweck1;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer ADD ort varchar(40) after plz;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte ort in die Tabelle kursteilnehmer aufgenommen", 287);
  }

  private void update0288(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table kursteilnehmer alter column vzweck1 varchar(140);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer modify column  vzweck1 varchar(140);\n");

    execute(conn, statements,
        "Spalte vzweck1 der Tabelle kursteilnehmer verl�ngert", 288);
  }

  private void update0289(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "update kursteilnehmer set vzweck1 = trim(concat(vzweck1, vzweck2));\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);
    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(
        conn,
        statements,
        "Spalte vzweck1 und vzweck2 in der Tabelle kursteilnehmer zusammengef�gt",
        289);
  }

  private void update0290(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer DROP vzweck2;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE kursteilnehmer DROP vzweck2;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte vzweck2 aus der Tabelle kursteilnehmer entfernt", 290);
  }

  private void update0291(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "alter table kursteilnehmer alter column name varchar(40);\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer modify column  name varchar(40);\n");

    execute(conn, statements,
        "Spalte name der Tabelle kursteilnehmer verl�ngert", 291);
  }

  private void update0292(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE abrechnungslauf ADD faelligkeit date before stichtag;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE abrechnungslauf ADD faelligkeit date after modus;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte faelligkeit in die Tabelle abrechnungslauf aufgenommen", 292);
  }

  private void update0293(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("CREATE TABLE lastschrift(");
    sb.append(" id IDENTITY(1),");
    sb.append(" abrechnungslauf INTEGER NOT NULL,");
    sb.append(" mitglied INTEGER,");
    sb.append(" kursteilnehmer INTEGER,");
    sb.append(" personenart CHAR(1),");
    sb.append(" anrede VARCHAR(10),");
    sb.append(" titel VARCHAR(10),");
    sb.append(" name VARCHAR(40) NOT NULL,");
    sb.append(" vorname VARCHAR(40),");
    sb.append(" strasse VARCHAR(40),");
    sb.append(" adressierungszusatz VARCHAR(40),");
    sb.append(" plz VARCHAR(10),");
    sb.append(" ort VARCHAR(40),");
    sb.append(" staat VARCHAR(50),");
    sb.append(" mandatid VARCHAR(35) NOT NULL,");
    sb.append(" mandatdatum DATE NOT NULL,");
    sb.append(" bic VARCHAR(11) NOT NULL,");
    sb.append(" lsname VARCHAR(70) NOT NULL,");
    sb.append(" iban VARCHAR(35) NOT NULL,");
    sb.append(" verwendungszweck VARCHAR(140) NOT NULL,");
    sb.append(" betrag double NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" PRIMARY KEY (id));\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("CREATE TABLE lastschrift(");
    sb.append(" id INTEGER AUTO_INCREMENT, ");
    sb.append(" abrechnungslauf INTEGER NOT NULL,");
    sb.append(" mitglied INTEGER,");
    sb.append(" kursteilnehmer INTEGER,");
    sb.append(" personenart CHAR(1),");
    sb.append(" anrede VARCHAR(10),");
    sb.append(" titel VARCHAR(10),");
    sb.append(" name VARCHAR(40) NOT NULL,");
    sb.append(" vorname VARCHAR(40),");
    sb.append(" strasse VARCHAR(40),");
    sb.append(" adressierungszusatz VARCHAR(40),");
    sb.append(" plz VARCHAR(10),");
    sb.append(" ort VARCHAR(40),");
    sb.append(" staat VARCHAR(50),");
    sb.append(" mandatid VARCHAR(35) NOT NULL,");
    sb.append(" mandatdatum DATE NOT NULL,");
    sb.append(" bic VARCHAR(11) NOT NULL,");
    sb.append(" lsname VARCHAR(70) NOT NULL,");
    sb.append(" iban VARCHAR(35) NOT NULL,");
    sb.append(" verwendungszweck VARCHAR(140) NOT NULL,");
    sb.append(" betrag double NOT NULL,");
    sb.append(" UNIQUE (id),");
    sb.append(" KEY (abrechnungslauf),");
    sb.append(" KEY (mitglied),");
    sb.append(" KEY(kursteilnehmer),");
    sb.append(" PRIMARY KEY (id)");
    sb.append(")  ENGINE=InnoDB;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Tabelle lastschrift erstellt", 293);
  }

  private void update0294(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id)  ON DELETE CASCADE;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 1 f�r lastschrift neu erstellt", 294);
  }

  private void update0295(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift2 FOREIGN KEY (mitglied) REFERENCES mitglied (id)  ON DELETE RESTRICT;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE RESTRICT;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 2 f�r lastschrift neu erstellt", 295);
  }

  private void update0296(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift3 FOREIGN KEY (kursteilnehmer) REFERENCES kursteilnehmer (id)  ON DELETE RESTRICT;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift3 FOREIGN KEY (kursteilnehmer) REFERENCES kursteilnehmer (id) ON DELETE RESTRICT;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements, "Foreign Key 3 f�r lastschrift neu erstellt", 296);
  }

  private void update0297(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoipersonenart char(1) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoipersonenart char(1) after kontoinhaber;\n");

    execute(conn, statements,
        "Spalte ktopersonenart in Tabelle mitglied eingef�gt", 297);
  }

  private void update0298(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoianrede varchar(10) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoianrede varchar(10) after ktoipersonenart;\n");

    execute(conn, statements,
        "Spalte ktoianrede in Tabelle mitglied eingef�gt", 298);
  }

  private void update0299(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoititel varchar(10) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoititel varchar(10) after ktoianrede;\n");

    execute(conn, statements, "Spalte ktoititel in Tabelle mitglied eingef�gt",
        299);
  }

  private void update0300(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoiname varchar(40) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoiname varchar(40) after ktoititel;\n");

    execute(conn, statements, "Spalte ktoiname in Tabelle mitglied eingef�gt",
        300);
  }

  private void update0301(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoivorname varchar(40) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoivorname varchar(40) after ktoiname;\n");

    execute(conn, statements,
        "Spalte ktoivorname in Tabelle mitglied eingef�gt", 301);
  }

  private void update0302(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoistrasse varchar(40) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoistrasse varchar(40) after ktoivorname;\n");

    execute(conn, statements,
        "Spalte ktoistrasse in Tabelle mitglied eingef�gt", 302);
  }

  private void update0303(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoiadressierungszusatz varchar(40) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoiadressierungszusatz varchar(40) after ktoistrasse;\n");

    execute(conn, statements,
        "Spalte ktoiadressierungszusatz in Tabelle mitglied eingef�gt", 303);
  }

  private void update0304(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoiplz varchar(10) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoiplz varchar(10) after ktoiadressierungszusatz;\n");

    execute(conn, statements, "Spalte ktoiplz in Tabelle mitglied eingef�gt",
        304);
  }

  private void update0305(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoiort varchar(40) before geburtsdatum;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table mitglied add column ktoiort varchar(40) after ktoiplz;\n");

    execute(conn, statements, "Spalte ktoiort in Tabelle mitglied eingef�gt",
        305);
  }

  private void update0306(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoistaat varchar(50) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoistaat varchar(50) after ktoiort;\n");

    execute(conn, statements, "Spalte ktoistaat in Tabelle mitglied eingef�gt",
        306);
  }

  private void update0307(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE mitglied set ktoiname = kontoinhaber;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte ktoiname mit kontoinhaber gef�llt", 307);
  }

  private void update0308(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied DROP kontoinhaber;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE mitglied DROP kontoinhaber;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte kontoinhaber aus der Tabelle mitglied entfernt", 308);
  }

  // Hinweis Ruediger Wurth: neue einstellung "vorlagencsvverzeichnis"
  private void update0309(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD vorlagencsvverzeichnis VARCHAR(200) BEFORE SPENDENBESCHEINIGUNGMINBETRAG;\n");
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD vorlagencsvverzeichnis VARCHAR(200) AFTER DATEINAMENMUSTERSPENDE;\n");
    execute(conn, statements,
        "Spalte vorlagencsvverzeichnis in die Tabelle einstellung aufgenommen",
        309);
  }

  private void update0310(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column personenart char(1) before name;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column personenart char(1) after id;\n");

    execute(conn, statements,
        "Spalte personenart in Tabelle kursteilnehmer eingef�gt", 310);
  }

  private void update0311(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column vorname varchar(40) before strasse;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column vorname varchar(40) after name;\n");

    execute(conn, statements,
        "Spalte vorname in Tabelle kursteilnehmer eingef�gt", 311);
  }

  private void update0312(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column adressierungszusatz varchar(40) before plz;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column adressierungszusatz varchar(40) after strasse;\n");

    execute(conn, statements,
        "Spalte adressierungszusatz in Tabelle kursteilnehmer eingef�gt", 312);
  }

  private void update0313(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column staat varchar(50) before vzweck1;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table kursteilnehmer add column staat varchar(50) after ort;\n");

    execute(conn, statements,
        "Spalte staat in Tabelle kursteilnehmer eingef�gt", 313);
  }

  private void update0314(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column anrede varchar(10) before name;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column anrede varchar(10) after personenart;\n");

    execute(conn, statements,
        "Spalte anrede in Tabelle kursteilnehmer eingef�gt", 314);
  }

  private void update0315(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column titel varchar(10) before name;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column titel varchar(10) after anrede;\n");

    execute(conn, statements,
        "Spalte titel in Tabelle kursteilnehmer eingef�gt", 315);
  }

  private void update0316(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table kursteilnehmer add column email varchar(50) before vzweck1;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table kursteilnehmer add column email varchar(50) after staat;\n");

    execute(conn, statements,
        "Spalte email in Tabelle kursteilnehmer eingef�gt", 316);
  }

  private void update0317(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table mitglied add column ktoiemail varchar(50) before geburtsdatum;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table mitglied add column ktoiemail varchar(50) after ktoistaat;\n");

    execute(conn, statements, "Spalte email in Tabelle mitglied eingef�gt", 317);
  }

  private void update0318(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table lastschrift add column email varchar(50) before mandatid;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "alter table lastschrift add column email varchar(50) after staat;\n");

    execute(conn, statements, "Spalte email in Tabelle lastschrift eingef�gt",
        318);
  }

  private void update0319(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift DROP lsname;\n");
    statements.put(DBSupportH2Impl.class.getName(), sb.toString());

    // Update fuer MySQL
    sb = new StringBuilder();
    sb.append("ALTER TABLE lastschrift DROP lsname;\n");
    statements.put(DBSupportMySqlImpl.class.getName(), sb.toString());

    execute(conn, statements,
        "Spalte lsname aus der Tabelle lastschrift entfernt", 319);
  }

  private void update0320(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "DROP TABLE bank";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Tabelle bank gel�scht", 320);
  }

  private void update0321(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "DROP TABLE sepaparam";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Tabelle sepaparam gel�scht", 321);
  }

  private void update0322(Connection conn) throws ApplicationException
  {
    if (driver.equals(H2))
    {
      return;
    }
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE anfangsbestand DROP FOREIGN KEY fkAnfangsbestand1;\n"
                + "ALTER TABLE arbeitseinsatz DROP FOREIGN KEY fkArbeitseinsatz1;\n"
                + "ALTER TABLE beitragsgruppe DROP FOREIGN KEY fkBeitragsgruppe1;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung1;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung2;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung3;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung4;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung5;\n"
                + "ALTER TABLE buchung DROP FOREIGN KEY fkBuchung6;\n"
                + "ALTER TABLE buchungdokument DROP FOREIGN KEY fkBuchungDokument1;\n"
                // +
                // "ALTER TABLE buchungsart DROP FOREIGN KEY fkBuchungsart1;\n"
                + "ALTER TABLE buchungsart DROP FOREIGN KEY fkBuchungsart2;\n"
                + "ALTER TABLE eigenschaft DROP FOREIGN KEY fkEigenschaft1;\n"
                + "ALTER TABLE eigenschaften DROP FOREIGN KEY fkEigenschaften2;\n"
                + "ALTER TABLE eigenschaften DROP FOREIGN KEY fkEigenschaften1;\n"
                + "ALTER TABLE formularfeld DROP FOREIGN KEY fkFormularfeld1;\n"
                + "ALTER TABLE lastschrift DROP FOREIGN KEY fkLastschrift1;\n"
                + "ALTER TABLE lastschrift DROP FOREIGN KEY fkLastschrift2;\n"
                + "ALTER TABLE lastschrift DROP FOREIGN KEY fkLastschrift3;\n"
                + "ALTER TABLE lehrgang DROP FOREIGN KEY fkLehrgang2;\n"
                + "ALTER TABLE lehrgang DROP FOREIGN KEY fkLehrgang1;\n"
                + "ALTER TABLE mailanhang DROP FOREIGN KEY fkMailAnhang1;\n"
                + "ALTER TABLE mailempfaenger DROP FOREIGN KEY fkMailempfaenger2;\n"
                + "ALTER TABLE mailempfaenger DROP FOREIGN KEY fkMailEmpfaenger1;\n"
                + "ALTER TABLE mitglied DROP FOREIGN KEY fkMitglied1;\n"
                + "ALTER TABLE mitglied DROP FOREIGN KEY fkMitglied2;\n"
                + "ALTER TABLE mitglieddokument DROP FOREIGN KEY fkMitgliedDokument1;\n"
                + "ALTER TABLE mitgliedfoto DROP FOREIGN KEY fkMitgliedfoto1;\n"
                + "ALTER TABLE mitgliedskonto DROP FOREIGN KEY fkMitgliedskonto1;\n"
                + "ALTER TABLE mitgliedskonto DROP FOREIGN KEY fkMitgliedskonto2;\n"
                + "ALTER TABLE spendenbescheinigung DROP FOREIGN KEY fkSpendenbescheinigung1;\n"
                + "ALTER TABLE spendenbescheinigung DROP FOREIGN KEY fkSpendenbescheinigung2;\n"
                + "ALTER TABLE wiedervorlage DROP FOREIGN KEY fkWiedervorlage1;\n"
                + "ALTER TABLE zusatzabbuchung DROP FOREIGN KEY fkZusatzabbuchung1;\n"
                + "ALTER TABLE zusatzbetragabrechnungslauf DROP FOREIGN KEY fkZusatzbetragabrechnungslauf2;\n"
                + "ALTER TABLE zusatzbetragabrechnungslauf DROP FOREIGN KEY fkZusatzbetragabrechnungslauf1;\n"
                + "ALTER TABLE zusatzfelder DROP FOREIGN KEY fkzusatzfelder1;\n"
                + "ALTER TABLE zusatzfelder DROP FOREIGN KEY fkZusatzfelder2;\n");

    execute(conn, statements, "Spaltentypen ge�ndert", 322);
  }

  private void update0323(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("anfangsbestand", "konto", "BIGINT");
    sql += alterColumn("arbeitseinsatz", "mitglied", "BIGINT");
    sql += alterColumn("beitragsgruppe", "buchungsart", "BIGINT");
    sql += alterColumn("buchung", "abrechnungslauf", "BIGINT");
    sql += alterColumn("buchung", "buchungsart", "BIGINT");
    sql += alterColumn("buchung", "konto", "BIGINT");
    sql += alterColumn("buchung", "mitgliedskonto", "BIGINT");
    sql += alterColumn("buchung", "projekt", "BIGINT");
    sql += alterColumn("buchung", "spendenbescheinigung", "BIGINT");
    sql += alterColumn("buchungdokument", "referenz", "BIGINT");
    sql += alterColumn("buchungsart", "buchungsklasse", "BIGINT");
    sql += alterColumn("eigenschaft", "eigenschaftgruppe", "BIGINT");
    sql += alterColumn("eigenschaften", "eigenschaft", "BIGINT");
    sql += alterColumn("eigenschaften", "mitglied", "BIGINT");
    sql += alterColumn("einstellung", "finanzamt", "VARCHAR(30)");
    sql += alterColumn("einstellung", "steuernummer", "VARCHAR(30)");
    sql += alterColumn("formularfeld", "formular", "BIGINT");
    sql += alterColumn("lastschrift", "abrechnungslauf", "BIGINT");
    sql += alterColumn("lastschrift", "kursteilnehmer", "BIGINT");
    sql += alterColumn("lastschrift", "mitglied", "BIGINT");
    sql += alterColumn("lehrgang", "lehrgangsart", "BIGINT");
    sql += alterColumn("lehrgang", "mitglied", "BIGINT");
    sql += alterColumn("mailanhang", "mail", "BIGINT");
    sql += alterColumn("mailempfaenger", "mail", "BIGINT");
    sql += alterColumn("mailempfaenger", "mitglied", "BIGINT");
    sql += alterColumn("mitglied", "adresstyp", "BIGINT");
    sql += alterColumn("mitglied", "beitragsgruppe", "BIGINT");
    sql += alterColumn("mitglieddokument", "referenz", "BIGINT");
    sql += alterColumn("mitgliedfoto", "mitglied", "BIGINT");
    sql += alterColumn("mitgliedskonto", "abrechnungslauf", "BIGINT");
    sql += alterColumn("mitgliedskonto", "mitglied", "BIGINT");
    sql += alterColumn("spendenbescheinigung", "formular", "BIGINT");
    sql += alterColumn("spendenbescheinigung", "mitglied", "BIGINT");
    sql += alterColumn("wiedervorlage", "mitglied", "BIGINT");
    sql += alterColumn("zusatzabbuchung", "mitglied", "BIGINT");
    sql += alterColumn("zusatzbetragabrechnungslauf", "abrechnungslauf",
        "BIGINT");
    sql += alterColumn("zusatzbetragabrechnungslauf", "zusatzbetrag", "BIGINT");
    sql += alterColumn("zusatzfelder", "felddefinition", "BIGINT");
    sql += alterColumn("zusatzfelder", "mitglied", "BIGINT");
    sql += alterColumn(MYSQL, "abrechnungslauf", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "adresstyp", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "anfangsbestand", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "arbeitseinsatz", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "beitragsgruppe", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "buchung", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "buchungdokument", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "buchungsart", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "buchungsklasse", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "eigenschaft", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "eigenschaften", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "eigenschaftgruppe", "id",
        "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "einstellung", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "felddefinition", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "formular", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "formularfeld", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "jahresabschluss", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "konto", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "kursteilnehmer", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "lastschrift", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "lehrgang", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "lehrgangsart", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "lesefeld", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mail", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mailanhang", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mailempfaenger", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mailvorlage", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mitglied", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mitglieddokument", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mitgliedfoto", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "mitgliedskonto", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "projekt", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "spendenbescheinigung", "id",
        "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "version", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "wiedervorlage", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "zusatzabbuchung", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "zusatzbetragabrechnungslauf", "id",
        "BIGINT AUTO_INCREMENT");
    sql += alterColumn(MYSQL, "zusatzfelder", "id", "BIGINT AUTO_INCREMENT");
    sql += alterColumn("abrechnungslauf", "dtausdruck", "tinyint(1)");
    sql += alterColumn("abrechnungslauf", "zusatzbetraege", "tinyint(1)");
    sql += alterColumn("abrechnungslauf", "kursteilnehmer", "tinyint(1)");
    sql += alterColumn("buchungsart", "spende", "tinyint(1)");
    sql += alterColumn("eigenschaftgruppe", "pflicht", "tinyint(1)");
    sql += alterColumn("eigenschaftgruppe", "max1", "tinyint(1)");
    sql += alterColumn("einstellung", "vorlaeufig", "tinyint(1)");
    sql += alterColumn("einstellung", "mitgliedsbeitraege", "tinyint(1)");
    sql += alterColumn("einstellung", "geburtsdatumpflicht", "tinyint(1)");
    sql += alterColumn("einstellung", "eintrittsdatumpflicht", "tinyint(1)");
    sql += alterColumn("einstellung", "sterbedatum", "tinyint(1)");
    sql += alterColumn("einstellung", "kommunikationsdaten", "tinyint(1)");
    sql += alterColumn("einstellung", "zusatzabbuchung", "tinyint(1)");
    sql += alterColumn("einstellung", "vermerke", "tinyint(1)");
    sql += alterColumn("einstellung", "wiedervorlage", "tinyint(1)");
    sql += alterColumn("einstellung", "kursteilnehmer", "tinyint(1)");
    sql += alterColumn("einstellung", "lehrgaenge", "tinyint(1)");
    sql += alterColumn("einstellung", "juristischepersonen", "tinyint(1)");
    sql += alterColumn("einstellung", "mitgliedfoto", "tinyint(1)");
    sql += alterColumn("einstellung", "auslandsadressen", "tinyint(1)");
    sql += alterColumn("einstellung", "arbeitseinsatz", "tinyint(1)");
    sql += alterColumn("einstellung", "dokumentenspeicherung", "tinyint(1)");
    sql += alterColumn("einstellung", "individuellebeitraege", "tinyint(1)");
    sql += alterColumn("einstellung", "externemitgliedsnummer", "tinyint(1)");
    sql += alterColumn("einstellung", "smtp_ssl", "tinyint(1)");
    sql += alterColumn("einstellung", "zusatzadressen", "tinyint(1)");
    sql += alterColumn("einstellung", "smtp_starttls", "tinyint(1)");
    sql += alterColumn("spendenbescheinigung", "ersatzaufwendungen",
        "tinyint(1)");
    sql += alterColumn("spendenbescheinigung", "unterlagenwertermittlung",
        "tinyint(1)");
    sql += alterColumn("zusatzfelder", "feldjanein", "tinyint(1)");

    statements.put(driver, sql);
    execute(conn, statements, "Spaltentypen ge�ndert", 323);
  }

  private void update0324(Connection conn) throws ApplicationException
  {
    if (driver.equals(H2))
    {
      return;
    }
    Map<String, String> statements = new HashMap<String, String>();
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE anfangsbestand ADD CONSTRAINT fkAnfangsbestand1 FOREIGN KEY (konto) REFERENCES konto (id);"
                + "ALTER TABLE arbeitseinsatz ADD CONSTRAINT fkArbeitseinsatz1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE beitragsgruppe ADD CONSTRAINT fkBeitragsgruppe1 FOREIGN KEY (buchungsart) REFERENCES buchungsart (id);\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung1 FOREIGN KEY (buchungsart) REFERENCES buchungsart (id);\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung2 FOREIGN KEY (konto) REFERENCES konto (id);\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung3 FOREIGN KEY (mitgliedskonto) REFERENCES mitgliedskonto (id);\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung4 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung5 FOREIGN KEY (spendenbescheinigung) REFERENCES spendenbescheinigung (id);\n"
                + "ALTER TABLE buchung ADD CONSTRAINT fkBuchung6 FOREIGN KEY (projekt) REFERENCES projekt (id);\n"
                + "ALTER TABLE buchungdokument ADD CONSTRAINT fkBuchungDokument1 FOREIGN KEY (referenz) REFERENCES buchung (id);\n"
                + "ALTER TABLE buchungsart ADD CONSTRAINT fkBuchungsart2 FOREIGN KEY (buchungsklasse) REFERENCES buchungsklasse (id);\n"
                + "ALTER TABLE eigenschaft ADD CONSTRAINT fkEigenschaft1 FOREIGN KEY (eigenschaftgruppe) REFERENCES eigenschaftgruppe (id);\n"
                + "ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften2 FOREIGN KEY (eigenschaft) REFERENCES eigenschaft (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE eigenschaften ADD CONSTRAINT fkEigenschaften1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE formularfeld ADD CONSTRAINT fkFormularfeld1 FOREIGN KEY (formular) REFERENCES formular (id) ON DELETE CASCADE ON UPDATE CASCADE;\n"
                + "ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift2 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n"
                + "ALTER TABLE lastschrift ADD CONSTRAINT fkLastschrift3 FOREIGN KEY (kursteilnehmer) REFERENCES kursteilnehmer (id);\n"
                + "ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang2 FOREIGN KEY (lehrgangsart) REFERENCES lehrgangsart (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE lehrgang ADD CONSTRAINT fkLehrgang1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mailanhang ADD CONSTRAINT fkMailAnhang1 FOREIGN KEY (mail) REFERENCES mail (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailempfaenger2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mailempfaenger ADD CONSTRAINT fkMailEmpfaenger1 FOREIGN KEY (mail) REFERENCES mail (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mitglied ADD CONSTRAINT fkMitglied1 FOREIGN KEY (beitragsgruppe) REFERENCES beitragsgruppe (id);\n"
                + "ALTER TABLE mitglied ADD CONSTRAINT fkMitglied2 FOREIGN KEY (adresstyp) REFERENCES adresstyp (id);\n"
                + "ALTER TABLE mitglieddokument ADD CONSTRAINT fkMitgliedDokument1 FOREIGN KEY (referenz) REFERENCES mitglied (id);\n"
                + "ALTER TABLE mitgliedfoto ADD CONSTRAINT fkMitgliedfoto1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE mitgliedskonto ADD CONSTRAINT fkMitgliedskonto2 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE spendenbescheinigung ADD CONSTRAINT fkSpendenbescheinigung1 FOREIGN KEY (formular) REFERENCES formular (id);\n"
                + "ALTER TABLE spendenbescheinigung ADD CONSTRAINT fkSpendenbescheinigung2 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n"
                + "ALTER TABLE wiedervorlage ADD CONSTRAINT fkWiedervorlage1 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n"
                + "ALTER TABLE zusatzabbuchung ADD CONSTRAINT fkZusatzabbuchung1 FOREIGN KEY (mitglied) REFERENCES mitglied (id);\n"
                + "ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf2 FOREIGN KEY (zusatzbetrag) REFERENCES zusatzabbuchung (id) ON DELETE CASCADE ON UPDATE CASCADE;\n"
                + "ALTER TABLE zusatzbetragabrechnungslauf ADD CONSTRAINT fkZusatzbetragabrechnungslauf1 FOREIGN KEY (abrechnungslauf) REFERENCES abrechnungslauf (id) ON DELETE CASCADE ON UPDATE CASCADE;\n"
                + "ALTER TABLE zusatzfelder ADD CONSTRAINT fkzusatzfelder1 FOREIGN KEY (mitglied) REFERENCES mitglied (id) ON DELETE CASCADE;\n"
                + "ALTER TABLE zusatzfelder ADD CONSTRAINT fkZusatzfelder2 FOREIGN KEY (felddefinition) REFERENCES felddefinition (id) ON DELETE CASCADE;\n");

    execute(conn, statements, "Spaltentypen ge�ndert", 324);
  }

  private void update0325(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "alter table abrechnungslauf alter column zahlungsgrund varchar(140);\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "alter table abrechnungslauf modify column zahlungsgrund varchar(140);\n");

    execute(conn, statements,
        "Spalte zahlungsgrund der Tabelle abrechnungslauf verl�ngert", 325);
  }

  private void update0326(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE buchung ADD splittyp integer before spendenbescheinigung;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE buchung ADD splittyp integer after splitid;\n");

    execute(conn, statements,
        "Spalte splittyp in die Tabelle buchung eingef�gt", 326);
  }

  private void update0327(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("buchung", "splitid", "BIGINT");

    statements.put(driver, sql);
    execute(conn, statements, "Spaltentypen ge�ndert", 327);
  }

  private void update0328(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(DBSupportH2Impl.class.getName(),
            "ALTER TABLE einstellung ADD arbeitsmodel integer not null default 1;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE einstellung ADD arbeitsmodel integer not null default 1;\n");

    execute(conn, statements,
        "Spalte Arbeitsmodel in die Tabelle einstellung eingef�gt", 328);
  }

  private void update0329(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements
        .put(
            DBSupportH2Impl.class.getName(),
            "CREATE TABLE qifimporthead( "
                + " id IDENTITY(1), "
                + " name VARCHAR(30), "
                + " beschreibung VARCHAR(30), "
                + " startsalto DOUBLE, "
                + " startdate DATE, "
                + " konto INTEGER, "
                + " importdatum DATE NOT NULL, "
                + " importfile VARCHAR(256), "
                + " processdate DATE, "
                + " UNIQUE(id), "
                + " PRIMARY KEY(id) "
                + ");\n "
                +

                " CREATE TABLE qifimportpos( "
                + "   posid IDENTITY(1), "
                + "   headid INTEGER NOT NULL, "
                + "   datum DATE NOT NULL, "
                + "   betrag DOUBLE NOT NULL, "
                + "   beleg VARCHAR(30), "
                + "   name VARCHAR(100), "
                + "   zweck VARCHAR(100), "
                + "   buchartex VARCHAR(50), "
                + "   buchart INTEGER, "
                + "   mitgliedbar VARCHAR(1), "
                + "   mitglied INTEGER, "
                + "   sperre VARCHAR(1), "
                + "   UNIQUE(posid) "
                + " );\n "
                +

                " ALTER TABLE qifimportpos ADD CONSTRAINT fkImpKntPos1 FOREIGN KEY (headid) REFERENCES qifimporthead(id)  DEFERRABLE;\n");

    // Update fuer MySQL
    statements
        .put(
            DBSupportMySqlImpl.class.getName(),
            "CREATE TABLE qifimporthead( "
                + " id int(10) AUTO_INCREMENT, "
                + " name VARCHAR(30), "
                + " beschreibung VARCHAR(30), "
                + " startdate DATE, "
                + " startsalto DOUBLE, "
                + " konto int(10), "
                + " importdatum DATE NOT NULL, "
                + " importfile VARCHAR(256), "
                + " processdate DATE, "
                + " UNIQUE(id), "
                + " PRIMARY KEY(id) "
                + " );\n "
                +

                "CREATE TABLE qifimportpos( "
                + "  posid int(10) AUTO_INCREMENT, "
                + "  headid int(10) NOT NULL, "
                + "  datum DATE NOT NULL, "
                + "  betrag DOUBLE NOT NULL, "
                + "  beleg VARCHAR(30), "
                + "  name VARCHAR(100), "
                + "  zweck VARCHAR(100), "
                + "  buchartex VARCHAR(50), "
                + "  buchart int(10), "
                + "  mitgliedbar VARCHAR(1), "
                + "  mitglied int(10), "
                + "  sperre VARCHAR(1), "
                + "  UNIQUE(posid) "
                + " );\n "
                +

                "ALTER TABLE qifimportpos ADD CONSTRAINT fkImpKntPos1 FOREIGN KEY (headid) REFERENCES qifimporthead(id);\n");

    execute(conn, statements,
        "Neue Tabellen f�r Import von Buchungen aus z.B. Quicken.", 329);
  }

  private void update0330(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "CREATE TABLE mitgliednextbgruppe( " + " id IDENTITY(1), "
            + " mitglied INTEGER, " + " beitragsgruppe INTEGER, "
            + " bemerkung VARCHAR(30), " + " abdatum DATE, " + " UNIQUE(id), "
            + " PRIMARY KEY(id) " + ");\n ");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "CREATE TABLE mitgliednextbgruppe( " + " id int(10) AUTO_INCREMENT, "
            + " mitglied int(10), " + " beitragsgruppe int(10), "
            + " bemerkung VARCHAR(30), " + " abdatum DATE, " + " UNIQUE(id), "
            + " PRIMARY KEY(id) " + " );\n ");

    execute(conn, statements, "Neue Tabelle f�r zuk�nftige Mitgliedsbeitr�ge.",
        330);
  }

  private void update0331(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung ADD altermodel integer not null default 1;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung ADD altermodel integer not null default 1;\n");

    execute(conn, statements,
        "Spalte Altermodel in die Tabelle einstellung eingef�gt", 331);
  }

  private void update0332(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ADD mandatversion integer before bic;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE mitglied ADD mandatversion integer after mandatdatum;\n");

    execute(conn, statements,
        "Spalte mandatversion in die Tabelle mitglied eingef�gt", 332);
  }

  private void update0333(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE mitglied set mandatversion = 1 WHERE mandatdatum is not null";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte mandatversion initialisiert", 333);
  }

  private void update0334(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE mitglied ADD mandatsequence VARCHAR(4) before bic;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE mitglied ADD mandatsequence VARCHAR(4) after mandatversion;\n");

    execute(conn, statements,
        "Spalte mandatsequence in die Tabelle mitglied eingef�gt", 334);
  }

  private void update0335(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE mitglied set mandatsequence = 'RCUR' WHERE blz is not null or iban is not null";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte mandatsequence initialisiert", 335);
  }

  private void update0336(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE lastschrift ADD mandatsequence VARCHAR(4) before bic;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE lastschrift ADD mandatsequence VARCHAR(4) after mandatdatum;\n");

    execute(conn, statements,
        "Spalte mandatsequence in die Tabelle lastschrift eingef�gt", 336);
  }

  private void update0337(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE mitglied set mandatsequence = 'RCUR'";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte mandatsequence initialisiert", 337);
  }

  private void update0338(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE abrechnungslauf ADD faelligkeit2 date before stichtag;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE abrechnungslauf ADD faelligkeit2 date after faelligkeit;\n");

    execute(conn, statements,
        "Spalte faelligkeit2 in die Tabelle abrechnungslauf eingef�gt", 338);
  }

  private void update0339(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE abrechnungslauf set faelligkeit2 = faelligkeit";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements,
        "Spalte faelligkeit in abrechungslauf initialisiert", 339);
  }

  private void update0340(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("einstellung", "name", "VARCHAR(70)");
    statements.put(driver, sql);
    execute(conn, statements, "", 340);
  }

  private void update0341(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "UPDATE einstellung set name = left(namelang,70) where namelang is not null or length(namelang) > 0";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "", 341);
  }

  private void update0342(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN namelang;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN namelang\n");

    execute(conn, statements, "", 342);
  }

  private void update0343(Connection conn) throws ApplicationException
  {

    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("lastschrift", "titel", "VARCHAR(40)");
    statements.put(driver, sql);
    execute(conn, statements, "", 343);
  }

  private void update0344(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("kursteilnehmer", "titel", "VARCHAR(40)");
    statements.put(driver, sql);
    execute(conn, statements, "", 344);
  }

  private void update0345(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = alterColumn("konto", "nummer", "VARCHAR(35)");
    statements.put(driver, sql);
    execute(conn, statements, "", 345);
  }

  private void update0346(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN delaytime;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE einstellung DROP COLUMN delaytime;\n");

    execute(conn, statements, "Spalte aus Tabelle einstellung entfernt", 346);
  }

  // TODO
  private void update0347(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE qifimporthead ADD startsaldo DOUBLE before startdate;\n");

    // Update fuer MySQL
    statements
        .put(DBSupportMySqlImpl.class.getName(),
            "ALTER TABLE qifimporthead ADD startsaldo DOUBLE after beschreibung;\n");

    execute(conn, statements,
        "Spalte startsaldo in die Tabelle qifimporthead eingef�gt", 347);
  }

  private void update0348(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    String sql = "update qifimporthead set startsaldo = startsaldo;\n";
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(), sql);

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(), sql);

    execute(conn, statements, "Spalte startsalto in startsaldo kopiert", 348);
  }

  private void update0349(Connection conn) throws ApplicationException
  {
    Map<String, String> statements = new HashMap<String, String>();
    // Update fuer H2
    statements.put(DBSupportH2Impl.class.getName(),
        "ALTER TABLE qifimporthead DROP COLUMN startsalto;\n");

    // Update fuer MySQL
    statements.put(DBSupportMySqlImpl.class.getName(),
        "ALTER TABLE qifimporthead DROP COLUMN startsalto;\n");

    execute(conn, statements, "Spalte aus Tabelle qifimporthead entfernt", 349);
  }

  private String alterColumn(String table, String column, String type)
  {
    return alterColumn(this.driver, table, column, type);
  }

  private String alterColumn(String _driver, String table, String column,
      String type)
  {
    if (driver.equals(H2) && _driver.equals(H2))
    {
      return "ALTER TABLE " + table + " ALTER COLUMN " + column + " " + type
          + ";\n";
    }
    if (driver.equals(MYSQL) && _driver.equals(MYSQL))
    {
      return "ALTER TABLE " + table + " MODIFY COLUMN " + column + " " + type
          + ";\n";
    }
    return "";
  }

}
