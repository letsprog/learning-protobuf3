
set PROTOBUF_BIN_DIR=%1
set SRC_DIR=%2
set PROTO_DEF_FILE_NAME=%3
set PROTO_DEF_FILE_PATH=%SRC_DIR%\%PROTO_DEF_FILE_NAME%
set DST_DIR=%4


if exist %DST_DIR%\ rd /q /s %DST_DIR%

mkdir %DST_DIR%


%PROTOBUF_BIN_DIR%\protoc.exe -I=%SRC_DIR% --java_out=%DST_DIR% %PROTO_DEF_FILE_PATH%

EXIT