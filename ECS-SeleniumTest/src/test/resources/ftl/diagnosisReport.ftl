<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />

    <style>
        body{
            font-family: SimSun;
        }
        @page {
            size: A5;
            margin: 0;
        }
        @page rotated { size: portrait;} //定义纸张旋转
                                           body {
                                               page: rotated; //引用旋转
                                           page-break-before:avoid;//前面不加空页
                                           page-break-after:avoid;//后面不加空页
                                           }
        body{
            margin: 0;
            padding: 0;
            text-align:center;
            width:148mm;
            height: 210mm;
            vertical-align: middle;
        }

        .pageNext{page-break-after: always;}
        .bodyc{
            height:210mm;
            display: table-cell;
            vertical-align: middle;
            text-align: center;
        }

        .content{
            width:135mm;
            padding: 10px;
            border: 1px solid;
            font-size: 12px;
            display:block;
            margin: 10px;
        }

        img{
            width:100px;
            height: 30px;
            display:block;
        }

        .title{

            width: 100%;
            font-size: 25px;
            font-weight: bold;
            display:inline;
            line-height: 34px;
        }

        table {
            width:135mm;


        }

        table tr td{
            text-align:left;
            line-height: 34px;
            padding:0px 20px;
        }
    </style>
</head>
<body>
<div class="bodyc">
    <div class="content">
        <div class="headTitle">
			<span>
				<img src="http://104.42.213.40:8080/static/prototype/images/logo2.png"  />
				<span class="title">檢驗單</span>
			</span>

        </div>
        <div>
            <table>
                <tr>
                    <td><label>院所名稱</label>:<label>${diagnosis.clinicName}</label></td>
                    <td><label>院所地址:</label>:<label>${diagnosis.clinicAddr}</label></td>
                </tr>
            </table>

            <table>
                <tr>
                    <td><label>會員姓名:</label>:<label>${diagnosis.vipName}</label></td>
                    <td><label>會 員 號:</label>:<label>${diagnosis.vioNo}</label></td>
                    <td><label>性 別:</label>:<label>${diagnosis.sex}</label></td>
                </tr>
                <tr>
                    <td><label>出生日期:</label>:<label>${diagnosis.birthDay}</label></td>
                    <td><label>開單日期:</label>:<label>${diagnosis.createDate}</label></td>
                    <td><label>就診科別 :</label>:<label>${diagnosis.category}</label></td>
                </tr>
            </table>
        </div>
    </div>
</div>


<#if diagnosis.nextPage >
<div class='pageNext'>
    <div class="bodyc">
        <div class="content">
            <div class="headTitle">
			<span>
				<img src="http://104.42.213.40:8080/static/prototype/images/logo2.png"  />
				<span class="title">檢驗單</span>
			</span>

            </div>
            <div>
                <table>
                    <tr>
                        <td><label>院所名稱</label>:<label>${diagnosis.clinicName}</label></td>
                        <td><label>院所地址:</label>:<label>${diagnosis.clinicAddr}</label></td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <td><label>會員姓名:</label>:<label>${diagnosis.vipName}</label></td>
                        <td><label>會 員 號:</label>:<label>${diagnosis.vioNo}</label></td>
                        <td><label>性 別:</label>:<label>${diagnosis.sex}</label></td>
                    </tr>
                    <tr>
                        <td><label>出生日期:</label>:<label>${diagnosis.birthDay}</label></td>
                        <td><label>開單日期:</label>:<label>${diagnosis.createDate}</label></td>
                        <td><label>就診科別 :</label>:<label>${diagnosis.category}</label></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>


</div>
</#if>
</body>
</html>