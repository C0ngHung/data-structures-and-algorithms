@AGENTS.md

## Claude Code — bổ sung riêng

- Trạng thái dự án nằm ở memory-bank/activeContext.md + memory-bank/progress.md. Đọc trước khi làm task liên quan tới việc đang dở.
- Mọi task đổi code → plan mode: trình bày plan và danh sách file, chờ duyệt. Không tự sửa khi chưa được approve.
- Sau khi sửa code Java, chạy gate rồi mới báo xong — không báo "done" khi chưa thấy output BUILD SUCCESS:
  - ./mvnw clean verify -B -DskipTests=false
- Không commit / push khi tôi không yêu cầu rõ ràng.
- Rule chi tiết theo path: bản gốc ở .agents/rules/, .claude/rules/ chỉ là pointer. Sửa nội dung rule thì sửa ở .agents/rules/.
- Slash command của repo: .claude/commands/*.md chỉ là wrapper @import — nội dung thật ở .agents/workflows/*.md.
- .claude/settings.json cưỡng chế AGENTS.md §8: permissions.deny chặn ghi vào **/target/**, và hook PreToolUse gọi .agents/guard/GuardCommand.java.
