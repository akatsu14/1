                if (soLienTiepLonHon1(i) == true) {
                    check = false;
                }
                for (Long j = (long) 1; j <= n; j++) {
                    if (khongChuaSo(i, j) == true) {
                        check = false;
                        break;
                    }
                }